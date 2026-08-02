package com.example.tms_android.Lessons.Lesson21

sealed class PostModel(open val id: Int) {
    data class AuthorPost(override val id: Int, val author: String, val text: String) : PostModel(id)
    data class ImagePost(override val id: Int, val imageRes: Int, val text: String) : PostModel(id)
    data class ButtonPost(override val id: Int, val text: String, val buttonLabel: String) : PostModel(id)
}
