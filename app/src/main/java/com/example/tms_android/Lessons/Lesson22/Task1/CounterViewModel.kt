package com.example.tms_android.Lessons.Lesson22.Task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val _counter = MutableLiveData<Int>(0)
    val counter: LiveData<Int> = _counter

    fun increment() {
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement() {
            _counter.value = _counter.value?.minus(1)

    }
}