package com.roix.semenbelalov.common.ui.delegates.vvm.list_rx

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.roix.semenbelalov.common.ui.adapters.BaseObservableAdapter

class ListHandleViewDelagate<Item, ItemDataBinding : ViewDataBinding> : IListHandleViewDelegate<Item> {

    lateinit var viewModel: IListHandleViewModelDelegate<Item>

    override fun initListHandle(provider: ListProvider, viewModelDelegate: IListHandleViewModelDelegate<Item>) {
        viewModel = viewModelDelegate
        provider.getRecyclerView().apply {
            val manager = LinearLayoutManager(context)
            layoutManager = manager
            adapter = BaseObservableAdapter<Item, ItemDataBinding>(viewModelDelegate.items, provider.getItemLayoutId())
            provider.getSwipeToRefreshLayout()?.setOnRefreshListener(SwipeToRefreshListListener())
        }
    }

    private inner class SwipeToRefreshListListener : SwipeRefreshLayout.OnRefreshListener {
        override fun onRefresh() {
            viewModel.refresh()
        }
    }

}