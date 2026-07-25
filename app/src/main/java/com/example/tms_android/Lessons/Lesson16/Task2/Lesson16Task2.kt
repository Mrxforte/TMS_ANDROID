package com.example.tms_android.Lessons.Lesson16.Task2

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tms_android.R
import kotlinx.coroutines.launch

class Lesson16Task2 : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson16_task2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
    }

    private fun loadUI() {
        val textView = findViewById<TextView>(R.id.status)
        val pb = findViewById<ProgressBar>(R.id.progressBar)

        lifecycleScope.launch {
            viewModel.flow.collect {
                if (it) {
                    textView.text = "Loading"
                    pb.visibility = View.VISIBLE
                } else {
                    textView.text = "Loaded"
                    pb.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.startLoading()
    }
}
