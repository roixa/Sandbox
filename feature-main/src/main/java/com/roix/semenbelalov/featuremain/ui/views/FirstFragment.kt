package com.roix.semenbelalov.featuremain.ui.views

import com.roix.semenbelalov.common.ui.fragments.BaseDatabindingFragment
import com.roix.semenbelalov.featuremain.R
import com.roix.semenbelalov.featuremain.databinding.FragmentFirstBinding
import com.roix.semenbelalov.featuremain.ui.viewmodels.FirstViewModel

class FirstFragment : BaseDatabindingFragment<FirstViewModel, FragmentFirstBinding>() {

    override val layoutId: Int = R.layout.fragment_first

    override fun setupBinding() {
        binding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }
    }

}

