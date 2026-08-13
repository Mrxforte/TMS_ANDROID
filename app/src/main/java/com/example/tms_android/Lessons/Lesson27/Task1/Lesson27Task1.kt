package com.example.tms_android.Lessons.Lesson27.Task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.databinding.ActivityLesson27Task1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lesson27Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson27Task1Binding
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson27Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        fetchPosts()
    }

    private fun setupRecyclerView() {
        postAdapter = PostAdapter(emptyList())
        binding.rvPosts.adapter = postAdapter
    }

    private fun fetchPosts() {
        RetrofitInstance.api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body() ?: emptyList()
                    postAdapter.updatePosts(posts)
                } else {
                    Toast.makeText(this@Lesson27Task1, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@Lesson27Task1, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
