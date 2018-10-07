package com.roix.semenbelalov.common.data

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

interface Parseble<out T> {
    fun isValid(): Boolean
    fun parse(): T
}
