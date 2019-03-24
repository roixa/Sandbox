package com.roix.semenbelalov.sandbox.di.feed

import com.roix.semenbelalov.sandbox.buissness.feed.FeedInteractor
import com.roix.semenbelalov.sandbox.buissness.feed.IFeedInteractor
import com.roix.semenbelalov.sandbox.data.repositories.feed.FeedRepository
import com.roix.semenbelalov.sandbox.data.repositories.feed.IFeedRepository
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class FeedModule : Module() {
    init {
        bind(IFeedInteractor::class.java).to(FeedInteractor::class.java).instancesInScope()
        bind(IFeedRepository::class.java).to(FeedRepository::class.java).instancesInScope()

    }
}