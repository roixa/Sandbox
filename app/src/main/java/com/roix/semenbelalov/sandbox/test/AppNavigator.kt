package com.roix.semenbelalov.sandbox.test

import androidx.navigation.NavController
import com.roix.semenbelalov.navigation.Screens
import com.roix.semenbelalov.sandbox.R

class AppNavigator(val navController: NavController) {
    fun nextScreen(screen: String) {
        val id = if (screen == Screens.SCREEN_DETAILS) {
            R.id.detailsActivity
        } else {
            R.id.firstFragment
        }

        navController.navigate(id)
    }
}