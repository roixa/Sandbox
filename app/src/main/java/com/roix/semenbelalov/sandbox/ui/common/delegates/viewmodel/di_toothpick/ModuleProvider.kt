package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick

import toothpick.config.Module

interface ModuleProvider {
    fun getModule(): Module
}