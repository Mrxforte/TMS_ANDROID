package com.example.tms_android.Lessons.Lesson25.Task2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class Task2ViewModel : ViewModel() {
    private val _message = MutableSharedFlow<String>()
    val message: SharedFlow<String> = _message.asSharedFlow()

    fun showMessage(text: String) {
        viewModelScope.launch {
            _message.emit(text)
        }
    }
}
