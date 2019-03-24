package com.roix.semenbelalov.sandbox.buissness.feed

import com.roix.semenbelalov.sandbox.data.models.FeedItem
import com.roix.semenbelalov.sandbox.data.repositories.feed.IFeedRepository
import io.reactivex.Single

import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class FeedInteractor @Inject constructor(val repository: IFeedRepository) : IFeedInteractor {
    override fun getItems(): Single<List<FeedItem>> = Single.create {
        it.onSuccess(listOf(FeedItem("gaga"), FeedItem("zaza")))
    }
}
