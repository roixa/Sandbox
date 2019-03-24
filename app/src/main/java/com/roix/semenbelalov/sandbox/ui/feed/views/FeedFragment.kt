package com.roix.semenbelalov.sandbox.ui.feed.views

import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.data.models.FeedItem
import com.roix.semenbelalov.sandbox.databinding.FragmentFeedBinding
import com.roix.semenbelalov.sandbox.databinding.ItemFeedBinding
import com.roix.semenbelalov.sandbox.ui.common.fragments.BaseToolbarListFragment
import com.roix.semenbelalov.sandbox.ui.feed.viewmodels.FeedViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class FeedFragment : BaseToolbarListFragment<FeedViewModel, FragmentFeedBinding, FeedItem, ItemFeedBinding>() {

    override val layoutId: Int = R.layout.fragment_feed

    override val itemLayoutId: Int = R.layout.item_feed

    override fun getToolbar(): Toolbar? = binding.toolbar.tb

    override fun getRecyclerView(): RecyclerView = binding.rv

    override fun getSwipeToRefreshLayout(): SwipeRefreshLayout? = binding.srl

    override fun setupBinding() {
        super.setupBinding()
        toolbarType.title.value = getString(R.string.title_feed)
    }

}

