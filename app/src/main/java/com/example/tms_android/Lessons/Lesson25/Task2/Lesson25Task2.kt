package com.example.tms_android.Lessons.Lesson25.Task2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tms_android.databinding.ActivityLesson25Task2Binding
import kotlinx.coroutines.launch

class Lesson25Task2 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson25Task2Binding
    private val viewModel: Task2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson25Task2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSendMessage.setOnClickListener {
            viewModel.showMessage("Hello")
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.message.collect { text ->
                    Toast.makeText(this@Lesson25Task2, text, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
