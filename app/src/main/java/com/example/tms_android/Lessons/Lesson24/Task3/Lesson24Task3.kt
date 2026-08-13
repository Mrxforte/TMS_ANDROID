package com.example.tms_android.Lessons.Lesson24.Task3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson24Task3Binding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lesson24Task3 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson24Task3Binding
    private var progressJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson24Task3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()
        startCounting()
    }

    private fun setupUI() {
        binding.button.text = getString(R.string.cancel_operation)
        binding.progressBar.max = 100
        binding.progressBar.progress = 0
        
        binding.button.setOnClickListener {
            if (progressJob?.isActive == true) {
                progressJob?.cancel()
                binding.title.text = getString(R.string.operation_canceled)
                binding.button.isEnabled = false
            }
        }
    }

    private fun startCounting() {
        progressJob = lifecycleScope.launch {
            try {
                for (i in 10 downTo 0) {
                    delay(1000)
                    binding.progressBar.progress = (10 - i) * 10
                    binding.title.text = "Count: $i"
                }
                binding.title.text = "Done!"
            } catch (e: Exception) {
                binding.title.text = "Операция отменена"
            }
        }
    }
}