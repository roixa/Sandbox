package com.roix.semenbelalov.sandbox.buissness.feed

import com.roix.semenbelalov.sandbox.data.models.FeedItem
import io.reactivex.Single

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
interface IFeedInteractor {
    fun getItems(): Single<List<FeedItem>>
}
