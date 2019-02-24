package com.roix.semenbelalov.featuremain.ui.views

import com.roix.semenbelalov.common.ui.fragments.BaseDatabindingFragment
import com.roix.semenbelalov.featuremain.R
import com.roix.semenbelalov.featuremain.databinding.FragmentSecondBinding
import com.roix.semenbelalov.featuremain.ui.viewmodels.SecondViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class SecondFragment : BaseDatabindingFragment<SecondViewModel, FragmentSecondBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_second

    override fun setupBinding() {
        super.setupBinding()
        getBinding()?.button?.setOnClickListener{
            getViewModel().onButtonClicked()
        }
    }

}

