package com.roix.semenbelalov.sandbox.activities


import androidx.appcompat.widget.Toolbar
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuredetails.ui.viewmodels.DetailsViewModel
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.ActivityDetailsBinding

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class DetailsActivity : BaseToolbarActivity<DetailsViewModel, ActivityDetailsBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_details

    override fun getToolbar(): Toolbar? = getBinding()?.toolbar!!.tb

}

