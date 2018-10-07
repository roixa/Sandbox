package com.roix.semenbelalov.featuremain.buissness

import com.roix.semenbelalov.featuremain.data.repositories.CommonApiRepository

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
