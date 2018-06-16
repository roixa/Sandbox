package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

interface IErrorHandleViewDelegate {
    fun initErrorHandle()
    fun handleError(error:Throwable)
}