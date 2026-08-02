package com.example.tms_android.Lessons.Lesson21.Task5

sealed class MultipleType {
    data class Header(val header: String) : MultipleType()
    data class Content(val content: String) : MultipleType()
    data class Button(val button: String) : MultipleType()
}
