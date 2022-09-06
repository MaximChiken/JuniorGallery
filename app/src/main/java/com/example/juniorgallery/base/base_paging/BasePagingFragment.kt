package com.example.juniorgallery.base.base_paging

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.ViewFlipper
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewbinding.ViewBinding
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.base.base_rcview.BasePhotoAdapter
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

abstract class BasePagingFragment<VB : ViewBinding, P : BasePagingPresenter<*>> : BaseFragment<VB, P>(),
    BasePagingView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BasePhotoAdapter<*>
    private lateinit var viewFlipper: ViewFlipper
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar


    abstract fun initializeAdapterAndRecyclerView(): Pair<BasePhotoAdapter<*>, RecyclerView>
    abstract fun initializeViewFliper(): ViewFlipper
    abstract fun initializeSwipeRefreshLayout(): SwipeRefreshLayout
    abstract fun initializeProgressBar(): ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        progressBar = initializeProgressBar()
        viewFlipper = initializeViewFliper()
        swipeRefreshLayout = initializeSwipeRefreshLayout()
        initializeAdapterAndRecyclerView().also {
            adapter = it.first
            recyclerView = it.second
            recyclerView.adapter = adapter
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUpListeners() {
        swipeRefreshLayout.setOnRefreshListener {
            presenter.swipeRefresh()
            swipeRefreshLayout.isRefreshing = false
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                (recyclerView.layoutManager as LinearLayoutManager).let {
                    val lastVisibleItemPosition = it.findLastVisibleItemPosition()
                    val totalItemsCount = it.itemCount
                    if (lastVisibleItemPosition >= kotlin.math.abs(totalItemsCount - 4)) {
                        presenter.loadNextPage()
                    }
                }
            }
        })
    }

    override fun isLoadingMore(bool: Boolean) {
        progressBar.isVisible = bool
    }

    override fun setLoader(isLoading: Boolean) {
        viewFlipper.displayedChild = if (isLoading) 1 else 0
    }

    override fun setError() {
        viewFlipper.displayedChild = 2
        showToast(R.string.connection_error)
    }

    override fun updateList(picture: List<PhotoInfoScreenModel>) = with(adapter) {
        submitList(picture)
        notifyDataSetChanged()
    }
}