package com.example.tms_android.Lessons.Lesson25.Task6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class Task6ViewModel : ViewModel() {
    private val _event = MutableSharedFlow<String>()
    val event: SharedFlow<String> = _event.asSharedFlow()

    fun save() {
        viewModelScope.launch {
            _event.emit("Saved")
        }
    }
}
