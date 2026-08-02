package com.example.tms_android.Lessons.Lesson27.Task1

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)
