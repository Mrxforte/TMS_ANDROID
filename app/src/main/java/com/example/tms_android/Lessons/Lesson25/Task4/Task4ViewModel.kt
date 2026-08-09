package com.example.tms_android.Lessons.Lesson25.Task4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class Task4ViewModel : ViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    val isFormValid: StateFlow<Boolean> = combine(email, password) { email, password ->
        email.contains("@") && password.length > 6
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)
}
