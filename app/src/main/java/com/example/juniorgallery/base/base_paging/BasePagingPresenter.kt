package com.example.juniorgallery.base.base_paging

import com.example.domain.entities.PhotoListEntity
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
abstract class BasePagingPresenter<T : BasePagingView> : BasePresenter<T>() {

    protected lateinit var uiPhotoListMapper: BaseUiMapper<PhotoListScreenModel, PhotoListEntity>

    private val compositeDisposable = CompositeDisposable()
    private val newPhotoList: MutableList<PhotoInfoScreenModel> = mutableListOf()
    private var pageNumber: Int = 1
    private var totalItemCount: Int = 0
    private var isLoading: Boolean = false
        set(value) {
            field = value
            viewState.isLoadingMore(value)
        }

    abstract fun getPhoto(pageNumber: Int): Single<PhotoListEntity>

    abstract fun initializeMapper(): BaseUiMapper<PhotoListScreenModel, PhotoListEntity>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        uiPhotoListMapper = initializeMapper()
        getPhoto(pageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setLoader(true) }
            .doOnSuccess { viewState.setLoader(false) }
            .subscribe({ photoInfo ->
                uiPhotoListMapper.map(photoInfo).data.forEach { newPhotoList.add(it) }
                viewState.updateList(newPhotoList)
                totalItemCount = photoInfo.data.count()
            }, {
                viewState.setError()
            }).let(compositeDisposable::add)
    }

    fun loadNextPage() {
        if (isHavingMore() && !isLoading) {
            pageNumber++
            getPage()
        }
    }

    fun getPage() {
        if (!isLoading) {
            getPhoto(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading = true }
                .doOnSuccess { isLoading = false }
                .subscribe({ photoInfo ->
                    uiPhotoListMapper.map(photoInfo).data.forEach { newPhotoList.add(it) }
                    viewState.updateList(newPhotoList)
                    totalItemCount = photoInfo.data.count()
                }, {
                    viewState.setError()
                }).let(compositeDisposable::add)
        }
    }

    fun swipeRefresh() {
        newPhotoList.clear()
        viewState.updateList(newPhotoList)
        pageNumber = 1
        getPage()
    }

    private fun isHavingMore() = totalItemCount >= ITEMS_PER_PAGE

    companion object {
        const val ITEMS_PER_PAGE = 20
    }
}