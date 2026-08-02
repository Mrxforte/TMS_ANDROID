package com.example.tms_android.Lessons.Lesson22.HomeWork2

sealed class DataState {
    object Idle : DataState()
    object Loading : DataState()
    data class Success(val data: String) : DataState()
    data class Error(val message: String) : DataState()
}
