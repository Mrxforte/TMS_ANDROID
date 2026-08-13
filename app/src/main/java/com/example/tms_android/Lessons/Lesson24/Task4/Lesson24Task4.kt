package com.example.tms_android.Lessons.Lesson24.Task4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.databinding.ActivityLesson24Task4Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Lesson24Task4 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson24Task4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson24Task4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startLoading()
    }

    private fun startLoading() {
        lifecycleScope.launch {
            // Main thread: Show progress
            binding.progressBar.visibility = android.view.View.VISIBLE
            binding.title.text = "Loading on Main thread..."
            
            withContext(Dispatchers.IO) {
                // IO thread: Perform long task
                delay(1000)
            }
            
            // Main thread: Hide progress / show result
            binding.progressBar.visibility = android.view.View.GONE
            binding.title.text = "Finished! Back to Main thread."
        }
    }
}
