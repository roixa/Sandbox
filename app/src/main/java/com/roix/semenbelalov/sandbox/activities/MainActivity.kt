package com.roix.semenbelalov.sandbox.activities

import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuremain.ui.viewmodels.MainViewModel
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.ActivityMainBinding

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class MainActivity : BaseToolbarActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main

    override val toolbar: Toolbar? = null// getBinding()?.toolbar!!.tb


    override fun setupBinding() {
       super.setupBinding()
        val finalHost = NavHostFragment.create(R.navigation.feature_main_nav_graph)
        supportFragmentManager.beginTransaction()
                .replace(R.id.root, finalHost)
                .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
                .commit()

        val c = NavHostFragment.findNavController(finalHost)
        c.navigate(R.id.secondFragment)
    }

//TODO detailsActivity id dublicate
}

