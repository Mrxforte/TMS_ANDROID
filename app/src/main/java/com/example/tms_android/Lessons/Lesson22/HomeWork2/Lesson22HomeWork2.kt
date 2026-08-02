package com.example.tms_android.Lessons.Lesson22.HomeWork2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.databinding.ActivityLesson22Homework2Binding

class Lesson22HomeWork2 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson22Homework2Binding
    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson22Homework2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLoad.setOnClickListener {
            viewModel.loadData()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is DataState.Idle -> {
                    binding.statusText.text = "State: Idle"
                    binding.progressBar.visibility = View.GONE
                    binding.dataText.text = ""
                    binding.btnLoad.isEnabled = true
                }
                is DataState.Loading -> {
                    binding.statusText.text = "State: Loading"
                    binding.progressBar.visibility = View.VISIBLE
                    binding.dataText.text = ""
                    binding.btnLoad.isEnabled = false
                }
                is DataState.Success -> {
                    binding.statusText.text = "State: Success"
                    binding.progressBar.visibility = View.GONE
                    binding.dataText.text = state.data
                    binding.btnLoad.isEnabled = true
                }
                is DataState.Error -> {
                    binding.statusText.text = "State: Error"
                    binding.progressBar.visibility = View.GONE
                    binding.dataText.text = state.message
                    binding.btnLoad.isEnabled = true
                }
            }
        }
    }
}
