package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleViewModel : BaseViewModel(){

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router


}
