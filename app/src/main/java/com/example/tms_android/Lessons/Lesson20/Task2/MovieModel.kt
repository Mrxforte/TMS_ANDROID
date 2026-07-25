package com.example.tms_android.Lessons.Lesson20.Task2

import androidx.annotation.DrawableRes

data class MovieModel(
    val title: String,
    val year: Int,
    @DrawableRes val imageResId: Int
)
