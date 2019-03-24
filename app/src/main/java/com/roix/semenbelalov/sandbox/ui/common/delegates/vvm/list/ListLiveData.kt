package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list

import androidx.lifecycle.LiveData

class ListLiveData<Item> : LiveData<List<Item>>() {
    fun update(newList: List<Item>) {
        value = newList
    }
}