package com.roix.semenbelalov.sandbox.buissness

import com.roix.semenbelalov.sandbox.data.repositories.common_api.CommonApiRepository

import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainInteractor : IMainInteractor {

    @Inject constructor()

    @Inject
    lateinit var common_apiRepository: CommonApiRepository

}
