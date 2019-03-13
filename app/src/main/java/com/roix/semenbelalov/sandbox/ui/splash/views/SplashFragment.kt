package com.roix.semenbelalov.sandbox.ui.splash.views

import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.FragmentSplashBinding
import com.roix.semenbelalov.sandbox.ui.common.fragments.BaseDatabindingFragment
import com.roix.semenbelalov.sandbox.ui.splash.viewmodels.SplashViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class SplashFragment : BaseDatabindingFragment<SplashViewModel, FragmentSplashBinding>() {

    override val layoutId: Int = R.layout.fragment_splash

    override fun setupBinding() {
        super.setupBinding()
        binding.button.setOnClickListener {
            viewModel.onClickedButton()
        }
    }

}

