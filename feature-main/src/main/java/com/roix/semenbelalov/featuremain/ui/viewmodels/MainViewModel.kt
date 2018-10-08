package com.roix.semenbelalov.featuremain.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.featuremain.buissness.IMainInteractor
import com.roix.semenbelalov.featuremain.di.MainModule
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainViewModel : BaseLifecycleViewModel() {

    @Inject
    protected lateinit var mainInteractor: IMainInteractor

    val text=MutableLiveData<String>()

    override fun getModule(): Module = MainModule()
}
