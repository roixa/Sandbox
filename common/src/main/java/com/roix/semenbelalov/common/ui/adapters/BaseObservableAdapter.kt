package com.roix.semenbelalov.common.ui.adapters

import androidx.annotation.LayoutRes
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.BR

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class BaseObservableAdapter<Item, DataBinding : ViewDataBinding>(items: ObservableList<Item>, val layoutId: Int)
    : BaseMultyTypeObservableAdapter<Item, DataBinding>(items) {

    override fun getItemCount(): Int = mItems.size

    override fun onBindDataBinding(dataBinding: DataBinding, position: Int) {
        onBindDataBinding(dataBinding, mItems.get(position))
    }

    protected fun onBindDataBinding(dataBinding: DataBinding, item: Item) {
        dataBinding.setVariable(BR.item, item)
    }

    fun getItem(position: Int): Item {
        return mItems.get(position)
    }

    @LayoutRes
    override fun getLayoutId(viewType: Int): Int {
        return layoutId
    }
}
