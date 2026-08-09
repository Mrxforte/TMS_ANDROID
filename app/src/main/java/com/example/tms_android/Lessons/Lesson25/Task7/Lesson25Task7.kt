package com.example.tms_android.Lessons.Lesson25.Task7

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tms_android.databinding.ActivityLesson25Task7Binding
import kotlinx.coroutines.launch

class Lesson25Task7 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson25Task7Binding
    private val viewModel: Task7ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson25Task7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
                    
                    when {
                        state.data != null -> {
                            binding.tvData.text = state.data
                            binding.tvData.setTextColor(android.graphics.Color.BLACK)
                        }
                        state.error != null -> {
                            binding.tvData.text = state.error
                            binding.tvData.setTextColor(android.graphics.Color.RED)
                        }
                        else -> {
                            binding.tvData.text = ""
                        }
                    }
                }
            }
        }
    }
}
