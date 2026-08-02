package com.example.tms_android.Lessons.Lesson22.Task3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import com.example.tms_android.databinding.ActivityLesson22Task3Binding

class Lesson22Task3 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson22Task3Binding
    val viewModel by viewModels<FormViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson22Task3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupValidation()
        setupObservers()
        
        // Initial button state
        binding.button6.isEnabled = false
    }

    private fun setupValidation() {
        binding.name.doAfterTextChanged { text ->
            viewModel.validateName(text?.toString() ?: "")
        }

        binding.email.doAfterTextChanged { text ->
            viewModel.validateEmail(text?.toString() ?: "")
        }

        binding.password.doAfterTextChanged { text ->
            viewModel.validatePassword(text?.toString() ?: "")
        }

        binding.button6.setOnClickListener {
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupObservers() {
        viewModel.nameError.observe(this, Observer { error ->
            binding.nameInputLayout.error = error
        })

        viewModel.emailError.observe(this, Observer { error ->
            binding.emailInputLayout.error = error
        })

        viewModel.passwordError.observe(this, Observer { error ->
            binding.passwordInputLayout.error = error
        })

        viewModel.formState.observe(this, Observer { state ->
            if (state == "Success") {
                viewModel.clearState()
            }
        })

        viewModel.isFormValid.observe(this, Observer { isValid ->
            binding.button6.isEnabled = isValid
        })
    }
}
