package com.roix.semenbelalov.common.ui.view

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.roix.semenbelalov.common.R

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
data class ToolbarType(val context: Context,
                       val visible: Boolean = true,
                       @DrawableRes val icon: Int = R.drawable.ic_back,
                       val title: String = "",
                       val subtitle: String = "",
                       val elevation: Int = ContextCompat.getColor(context, android.R.color.white),
                       val backgroundColor: Int = ContextCompat.getColor(context, R.color.colorPrimary),
                       val iconColor: Int = ContextCompat.getColor(context, android.R.color.white),
                       val titleColor: Int = ContextCompat.getColor(context, android.R.color.white),
                       val subtitleColor: Int = ContextCompat.getColor(context, android.R.color.white)
) {
    fun isIconVisible(): Boolean {
        return R.drawable.none !== icon
    }
}
