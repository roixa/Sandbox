package com.roix.semenbelalov.sandbox.utils.binding

import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.ObservableList

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
@BindingConversion
fun convertBooleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:srcVector")
fun setSrcVector(imageView: ImageView, @DrawableRes res: Int) {
    imageView.setImageResource(res)
}

@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}



@BindingAdapter("bind:tint")
fun setTint(view: ImageView, @ColorRes colorRes: Int) {
    view.setColorFilter(ContextCompat.getColor(view.context, colorRes))
}

@BindingAdapter("bind:tintColor")
fun setTintColor(view: ImageView, color: Int) {
    view.setColorFilter(color)
}

fun <Item> ObservableList<Item>.update(list: List<Item>?, always: Boolean = false) {
    if (list != null && !always) {
        if (list.isEmpty()) {
            this.clear()
            return
        }
        val minSize =
                if (this.size > list.size) list.size
                else this.size
        val add = if (list.size > this.size) {
            val down = if (minSize == 0) 0 else minSize
            list.subList(down, list.size)
        } else emptyList()

        val remove = if (this.size > list.size && this.isNotEmpty()) {
            this.subList(minSize, this.size)
        } else emptyList<Item>()
        var i = 0
        val iterator = listIterator()
        while (iterator.hasNext() && i < minSize) {
            val curr = iterator.next()
            val new = list[i]
            i++
            if (curr!! != new) {
                iterator.set(new)
            }

        }
        removeAll(remove)
        addAll(add)

    } else {
        clear()
        addAll(list ?: emptyList())
    }

}