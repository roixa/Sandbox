package com.roix.semenbelalov.sandbox.ui.common.adapters

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */


interface DataChangedListener {
    fun adapterNotifyItemRangeChanged(positionStart: Int, itemCount: Int)

    fun adapterNotifyItemRangeInserted(positionStart: Int, itemCount: Int)

    fun adapterNotifyItemRangeRemoved(fromPosition: Int, itemCount: Int)
}
