package com.roix.semenbelalov.featuredetails.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.roix.semenbelalov.featuredetails.R

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val ret = inflater.inflate(R.layout.fragment_third, container, false)
        val b = ret.findViewById<View>(R.id.button)
        b.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.detailsActivity))
        return ret
    }


}
