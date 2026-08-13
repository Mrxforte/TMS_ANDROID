package com.example.tms_android.Lessons.Lesson24.Task6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.databinding.ActivityLesson24Task6Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lesson24Task6 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson24Task6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson24Task6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        runChain()
    }

    private fun runChain() {
        lifecycleScope.launch {
            val token = getToken()
            val data = fetchData(token)
            val result = processData(data)
            binding.title.text = result
        }
    }

    private suspend fun getToken(): String {
        delay(100)
        return "TOKEN_123"
    }

    private suspend fun fetchData(token: String): String {
        delay(100)
        return "Data for $token"
    }

    private suspend fun processData(data: String): String {
        delay(100)
        return "Processed: $data"
    }
}
