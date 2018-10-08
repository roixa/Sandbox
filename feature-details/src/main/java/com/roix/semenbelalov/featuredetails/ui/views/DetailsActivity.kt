package com.roix.semenbelalov.featuredetails.ui.views


import androidx.appcompat.widget.Toolbar
import com.roix.semenbelalov.common.ui.activities.BaseToolbarActivity
import com.roix.semenbelalov.featuredetails.R
import com.roix.semenbelalov.featuredetails.databinding.ActivityDetailsBinding
import com.roix.semenbelalov.featuredetails.ui.viewmodels.DetailsViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class DetailsActivity : BaseToolbarActivity<DetailsViewModel, ActivityDetailsBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_details

    override fun getToolbar(): Toolbar? = getBinding()?.toolbar!!.tb

}

