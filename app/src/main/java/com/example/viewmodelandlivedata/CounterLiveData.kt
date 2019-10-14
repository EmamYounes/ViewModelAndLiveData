package com.example.viewmodelandlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterLiveData : ViewModel() {
    val counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }
}