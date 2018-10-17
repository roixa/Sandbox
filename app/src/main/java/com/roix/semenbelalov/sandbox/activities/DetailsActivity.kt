package com.roix.semenbelalov.sandbox.activities


import com.roix.semenbelalov.common.ui.activities.BaseLifecycleActivity
import com.roix.semenbelalov.featuredetails.ui.viewmodels.DetailsViewModel
import com.roix.semenbelalov.sandbox.R

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class DetailsActivity : BaseLifecycleActivity<DetailsViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_details

}

