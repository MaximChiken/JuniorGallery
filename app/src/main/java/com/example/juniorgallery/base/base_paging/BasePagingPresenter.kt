package com.example.juniorgallery.base.base_paging

import com.example.domain.entities.PhotoEntity
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
abstract class BasePagingPresenter<T : BasePagingView> : BasePresenter<T>() {

    private val compositeDisposable = CompositeDisposable()
    private val newPhotoList: MutableList<PhotoInfoEntity> = mutableListOf()
    private var pageNumber: Int = 1
    private var totalItemCount: Int = 0
    private var isLoading: Boolean = false
        set(value) {
            field = value
            viewState.isLoadingMore(value)
        }

    abstract fun getPhoto(pageNumber: Int): Single<PhotoEntity>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getPhoto(pageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setLoader(true) }
            .doOnSuccess { viewState.setLoader(false) }
            .subscribe({ it ->
                it.data.forEach { newPhotoList.add(it) }
                viewState.updateList(newPhotoList)
                totalItemCount = it.data.count()
            }, {
                viewState.setError()
            }).let(compositeDisposable::add)
    }

    fun loadNextPage(){
        if(isHavingMore() && !isLoading){
            pageNumber++
            getPage()
        }
    }

    private fun getPage() {
        if (!isLoading) {
            getPhoto(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading = true }
                .doOnSuccess { isLoading = false }
                .subscribe({ it ->
                    it.data.forEach { newPhotoList.add(it) }
                    viewState.updateList(newPhotoList)
                    totalItemCount = it.data.count()
                }, {
                    viewState.setError()
                }).let(compositeDisposable::add)
        }
    }

    private fun isHavingMore() = totalItemCount.toFloat() / ITEMS_PER_PAGE.toFloat() >= pageNumber

    fun swipeRefresh() {
        newPhotoList.clear()
        viewState.updateList(newPhotoList)
        pageNumber = 1
        getPage()
    }

    companion object{
        const val ITEMS_PER_PAGE = 20
    }
}