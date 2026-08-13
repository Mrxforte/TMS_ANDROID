package com.example.tms_android.Lessons.Lesson24.Task2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.databinding.ActivityLesson24Task2Binding
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class Lesson24Task2 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson24Task2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson24Task2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLoad.setOnClickListener {
            loadParallel()
        }
    }

    private fun loadParallel() {
        lifecycleScope.launch {
            binding.btnLoad.isEnabled = false
            binding.tvResult.text = "Loading..."
            
            val time = measureTimeMillis {
                val user = async { loadUser() }
                val posts = async { loadPosts() }
                
                val userData = user.await()
                val postsData = posts.await()
                
                binding.tvResult.text = "User: $userData\nPosts count: ${postsData.size}"
            }
            
            binding.tvResult.append("\nTotal time: $time ms")
            binding.btnLoad.isEnabled = true
        }
    }

    private suspend fun loadUser(): String {
        delay(1000)
        return "Azamat"
    }

    private suspend fun loadPosts(): List<String> {
        delay(1000)
        return listOf("Post 1", "Post 2", "Post 3")
    }
}
