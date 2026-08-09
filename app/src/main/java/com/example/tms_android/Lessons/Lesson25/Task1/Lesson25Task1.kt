package com.example.tms_android.Lessons.Lesson25.Task1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.databinding.ActivityLesson25Task1Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class Lesson25Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson25Task1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson25Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStartFlow.setOnClickListener {
            startColdFlow()
        }
    }

    private fun startColdFlow() {
        lifecycleScope.launch {
            binding.tvStatus.text = "Flow started..."
            (1..5).asFlow()
                .onEach { delay(1000) } // Emit every second
                .map { it * 10 }
                .filter { it % 20 == 0 } // Even (specifically multiples of 20 since we map by 10)
                .collect { value ->
                    Log.d("Lesson25Task1", "Value: $value")
                    binding.tvStatus.text = "Collected: $value"
                }
            binding.tvStatus.text = "Flow completed"
        }
    }
}
