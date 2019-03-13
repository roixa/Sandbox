package com.roix.semenbelalov.sandbox.data.common

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

interface Parseble<out T> {
    fun isValid(): Boolean
    fun parse(): T
}
