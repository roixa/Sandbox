package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView

interface ListProvider {
    fun getItemLayoutId(): Int
    fun getRecyclerView(): RecyclerView
    fun getSwipeToRefreshLayout(): SwipeRefreshLayout?
}