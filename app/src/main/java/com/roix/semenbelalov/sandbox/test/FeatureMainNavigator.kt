package com.roix.semenbelalov.sandbox.test

import androidx.navigation.NavController
import com.roix.semenbelalov.featuremain.test.IFeatureMainNavigator

class FeatureMainNavigator(val navController: NavController):IFeatureMainNavigator {

    override fun gotoFeatureDetails() {
//        navController.navigate(R.id.detailsActivity)
    }
}