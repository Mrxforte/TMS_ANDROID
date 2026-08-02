package com.example.tms_android.Lessons.Lesson22.Task1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R

class Lesson22Task1 : AppCompatActivity() {
    val viewModel by viewModels<CounterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson22_task1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
    }

    private fun loadUI() {
        val counterText = findViewById<TextView>(R.id.counterText)
        val decrementButton = findViewById<TextView>(R.id.decrement)
        val incrementButton = findViewById<TextView>(R.id.increment)

        counterText.text = viewModel.counter.value.toString()

        decrementButton.setOnClickListener {
            viewModel.decrement()
            counterText.text = viewModel.counter.value.toString()
        }
        incrementButton.setOnClickListener {
            viewModel.increment()
            counterText.text = viewModel.counter.value.toString()
        }
    }
}
