package com.roix.semenbelalov.sandbox.ui.feed.viewmodels

import com.roix.semenbelalov.sandbox.buissness.feed.IFeedInteractor
import com.roix.semenbelalov.sandbox.data.models.FeedItem
import com.roix.semenbelalov.sandbox.di.feed.FeedModule
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseListViewModel
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class FeedViewModel : BaseListViewModel<FeedItem>() {

    @Inject
    protected lateinit var interactor: IFeedInteractor

    override val module: Module = FeedModule()

    override fun onBindFirstView() {
        super.onBindFirstView()
        interactor.getItems().sub {
            items.update(it)
        }
    }

    override fun refresh() {
        super.refresh()
        interactor.getItems().sub {
            items.update(it)
        }
    }
}
