package com.roix.semenbelalov.sandbox.ui.main.views

import androidx.appcompat.widget.Toolbar
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.FragmentMainBinding
import com.roix.semenbelalov.sandbox.ui.common.fragments.BaseToolbarFragment
import com.roix.semenbelalov.sandbox.ui.main.viewmodels.MainViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class MainFragment : BaseToolbarFragment<MainViewModel, FragmentMainBinding>() {

    override val layoutId: Int = R.layout.fragment_main

    override fun getToolbar(): Toolbar? = binding.toolbar.tb

    override fun setupBinding() {
        super.setupBinding()
        toolbarType.title.value = getString(R.string.title_main)
        toolbarType.subtitle.value = getString(R.string.app_name)
        binding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }
    }
}

