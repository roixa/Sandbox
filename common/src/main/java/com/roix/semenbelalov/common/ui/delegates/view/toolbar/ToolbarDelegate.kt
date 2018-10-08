package com.roix.semenbelalov.common.ui.delegates.view.toolbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.roix.semenbelalov.common.BR
import com.roix.semenbelalov.common.R
import com.roix.semenbelalov.common.databinding.MenuItemBinding
import com.roix.semenbelalov.common.ui.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.common.ui.view.ToolbarType
import kotlinx.android.synthetic.main.toolbar.view.*
import java.lang.ref.WeakReference

class ToolbarDelegate : IToolbarDelegate {

    lateinit var databinding: WeakReference<IDatabindingHandleDelegate<*>>
    lateinit var toolbarProvider: WeakReference<ToolbarProvider>
    lateinit var context: WeakReference<Context>

    override fun initToolbarDelegate(databindingDelegate: IDatabindingHandleDelegate<*>, toolbar: ToolbarProvider, c: Context) {
        databinding = WeakReference(databindingDelegate)
        toolbarProvider = WeakReference(toolbar)
        context = WeakReference(c)
        setupToolbar((ToolbarType(c)))
    }

    override fun setupToolbar(toolbarType: ToolbarType) {
        databinding.get()?.getBinding()?.setVariable(BR.toolbarType, toolbarType)
        val toolbar = toolbarProvider.get()?.getToolbar()
        if (toolbar != null) {
            toolbar.navigation_tb
                    .setOnClickListener {
                        if (R.drawable.ic_navigation_menu === toolbarType.icon) {
                            openNavigationView()
                        } else if (R.drawable.ic_back === toolbarType.icon) {
                            goBack()
                        }
                    }
            clearToolbarItems()
        }
    }

    override fun addToolbarItem(drawableIcon: Int, onClickListener: View.OnClickListener) {
        val toolbar = toolbarProvider.get()?.getToolbar()
        val c = context.get()
        if (toolbar != null && c != null) {
            val view = LayoutInflater.from(c).inflate(R.layout.menu_item, toolbar, false)
            view.setOnClickListener(onClickListener)
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.addView(view)
            val menuItemBinding = MenuItemBinding.bind(view)
            menuItemBinding.icon = ContextCompat.getDrawable(c, drawableIcon)
        }
    }

    override fun addToolbarItem(view: View) {
        val toolbar = toolbarProvider.get()?.getToolbar()
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.addView(view)
        }
    }

    override fun clearToolbarItems() {
        val toolbar = toolbarProvider.get()?.getToolbar()
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            itemContainer.removeAllViews()
        }
    }

    override fun hideToolbarItems() {
        val toolbar = toolbarProvider.get()?.getToolbar()
        if (toolbar != null) {
            val itemContainer = toolbar.ll_items as LinearLayout
            var i = 0
            while (i < itemContainer.childCount) {
                itemContainer.getChildAt(i).visibility = View.GONE
                i++
            }
        }
    }

    override fun goBack() {

    }

    override fun openNavigationView() {

    }
}