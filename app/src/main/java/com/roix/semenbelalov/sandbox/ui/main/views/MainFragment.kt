package com.roix.semenbelalov.sandbox.ui.main.views

import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.FragmentMainBinding
import com.roix.semenbelalov.sandbox.ui.common.fragments.BaseDatabindingFragment
import com.roix.semenbelalov.sandbox.ui.main.viewmodels.MainViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

class MainFragment : BaseDatabindingFragment<MainViewModel, FragmentMainBinding>() {

    override val layoutId: Int = R.layout.fragment_main

}

