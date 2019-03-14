package com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.roix.semenbelalov.sandbox.BR
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.MenuItemBinding
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.view.ToolbarType
import kotlinx.android.synthetic.main.toolbar.view.*

class ToolbarDelegate : IToolbarDelegate {

    lateinit var databindingDelegate: IDatabindingHandleDelegate<*, *>
    lateinit var toolbarProvider: ToolbarProvider
    lateinit var context: Context

    override fun initToolbarDelegate(databindingDelegate: IDatabindingHandleDelegate<*, *>, toolbar: ToolbarProvider, c: Context) {
        this.databindingDelegate = databindingDelegate
        toolbarProvider = toolbar
        context = c
        setupToolbar((ToolbarType(c)))
    }

    override fun setupToolbar(toolbarType: ToolbarType) {
        databindingDelegate.binding.setVariable(BR.toolbarType, toolbarType)
//        val toolbar = toolbarProvider.get()?.getToolbar()
//        if (toolbar != null) {
//            toolbar.navigation_tb
//                    .setOnClickListener {
//                        if (R.drawable.ic_navigation_menu === toolbarType.icon) {
//                            openNavigationView()
//                        } else if (R.drawable.ic_back === toolbarType.icon) {
//                            goBack()
//                        }
//                    }
//            clearToolbarItems()
//        }
    }

    override fun addToolbarItem(drawableIcon: Int, onClickListener: View.OnClickListener) {
        val toolbar = toolbarProvider.toolbar
        if (toolbar != null) {
            val view = LayoutInflater.from(context).inflate(R.layout.menu_item, toolbar, false)
            view.setOnClickListener(onClickListener)
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.addView(view)
            val menuItemBinding = MenuItemBinding.bind(view)
            menuItemBinding.icon = ContextCompat.getDrawable(context, drawableIcon)
        }
    }

    override fun addToolbarItem(view: View) {
        val toolbar = toolbarProvider.toolbar
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.addView(view)
        }
    }

    override fun clearToolbarItems() {
        val toolbar = toolbarProvider.toolbar
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.removeAllViews()
        }
    }

    override fun hideToolbarItems() {
        val toolbar = toolbarProvider.toolbar
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            var i = 0
            while (i < itemContainer.childCount) {
                itemContainer.getChildAt(i).visibility = View.GONE
                i++
            }
        }
    }

    override fun openNavigationView() {

    }
}