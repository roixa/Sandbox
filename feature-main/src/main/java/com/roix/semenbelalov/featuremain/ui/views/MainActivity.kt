package com.roix.semenbelalov.featuremain.ui.views

import android.support.v7.widget.Toolbar
import com.roix.semenbelalov.common.databinding.ActivityMainBinding
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuremain.R
import com.roix.semenbelalov.featuremain.ui.viewmodels.MainViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class MainActivity : BaseToolbarActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getToolbar(): Toolbar? = getBinding()?.toolbar!!.tb


    override fun setupBinding() {
        super.setupBinding()

    }

}

