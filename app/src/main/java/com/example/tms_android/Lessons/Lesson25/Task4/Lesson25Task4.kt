package com.example.tms_android.Lessons.Lesson25.Task4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tms_android.databinding.ActivityLesson25Task4Binding
import kotlinx.coroutines.launch

class Lesson25Task4 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson25Task4Binding
    private val viewModel: Task4ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson25Task4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        binding.etEmail.doAfterTextChanged { text ->
            viewModel.email.value = text?.toString() ?: ""
        }
        binding.etPassword.doAfterTextChanged { text ->
            viewModel.password.value = text?.toString() ?: ""
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isFormValid.collect { isValid ->
                    binding.btnSubmit.isEnabled = isValid
                }
            }
        }
    }
}
