package com.roix.semenbelalov.featuremain.ui.views

import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuremain.R
import com.roix.semenbelalov.featuremain.databinding.ActivityMainBinding
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
        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }

}

