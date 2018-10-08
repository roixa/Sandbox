package com.roix.semenbelalov.common.ui.delegates.view.toolbar

import android.content.Context
import android.view.View
import androidx.annotation.DrawableRes
import com.roix.semenbelalov.common.ui.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.common.ui.view.ToolbarType

interface IToolbarDelegate {
    fun initToolbarDelegate(databindingDelegate: IDatabindingHandleDelegate<*>, toolbarProvider: ToolbarProvider, context: Context)
    fun setupToolbar(toolbarType: ToolbarType)
    fun addToolbarItem(@DrawableRes drawableIcon: Int, onClickListener: View.OnClickListener)
    fun addToolbarItem(view: View)
    fun clearToolbarItems()
    fun hideToolbarItems()
    fun goBack()
    fun openNavigationView()

}