package com.roix.semenbelalov.sandbox.activities

import androidx.appcompat.widget.Toolbar
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuremain.ui.viewmodels.MainViewModel
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.ActivityMainBinding

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class MainActivity : BaseToolbarActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getToolbar(): Toolbar? = getBinding()?.toolbar!!.tb


}

