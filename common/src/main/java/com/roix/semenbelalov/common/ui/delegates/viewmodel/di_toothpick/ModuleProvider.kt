package com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick

import toothpick.config.Module

interface ModuleProvider {
    fun getModule(): Module
}