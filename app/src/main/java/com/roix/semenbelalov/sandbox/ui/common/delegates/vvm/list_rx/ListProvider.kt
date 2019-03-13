package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface ListProvider {
    fun getItemLayoutId(): Int
    fun getRecyclerView(): RecyclerView
    fun getSwipeToRefreshLayout(): SwipeRefreshLayout?
}