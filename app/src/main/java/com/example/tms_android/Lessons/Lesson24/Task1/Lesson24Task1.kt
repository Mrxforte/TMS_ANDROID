package com.example.tms_android.Lessons.Lesson24.Task1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.databinding.ActivityLesson24Task1Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lesson24Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson24Task1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson24Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStart.setOnClickListener {
            startTask()
        }
    }

    private fun startTask() {
        lifecycleScope.launch {
            binding.btnStart.isEnabled = false
            binding.tvStatus.text = "Начало"
            delay(2000)
            binding.tvStatus.text = "Конец"
            binding.btnStart.isEnabled = true
        }
    }
}
