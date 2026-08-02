package com.example.tms_android.Lessons.Lesson27.Task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun fetchPosts() {
        _isLoading.value = true
        RetrofitInstance.api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _posts.value = response.body() ?: emptyList()
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                _isLoading.value = false
                _errorMessage.value = "Failure: ${t.message}"
            }
        })
    }
}
