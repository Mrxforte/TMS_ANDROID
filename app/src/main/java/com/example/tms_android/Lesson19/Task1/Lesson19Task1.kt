package com.example.tms_android.Lesson19.Task1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson19Task1Binding
import com.google.android.material.snackbar.Snackbar

class Lesson19Task1 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson19Task1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson19Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadUI()
    }

    private fun loadUI() {
        binding.button.setOnClickListener {
            if (binding.text.text.isNotEmpty())
                binding.text.text = "This is changed text"
            Snackbar.make(binding.root, "This is a Snackbar", Snackbar.LENGTH_SHORT).show()
        }
    }
}
