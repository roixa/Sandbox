package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface ListViewProvider {
    val itemLayoutId: Int
    fun getRecyclerView(): RecyclerView
    fun getSwipeToRefreshLayout(): SwipeRefreshLayout?
}