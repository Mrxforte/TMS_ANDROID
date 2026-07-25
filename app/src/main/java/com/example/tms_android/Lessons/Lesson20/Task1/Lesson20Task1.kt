package com.example.tms_android.Lessons.Lesson20.Task1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson20Task1Binding

class Lesson20Task1 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson20Task1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson20Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadUI()
    }

    private fun loadUI() {
        val cityList = listOf(
            "Moscow", "London", "Paris", "New York", "Tokyo",
            "Berlin", "Rome", "Madrid", "Tashkent", "Nukus",
            "Seoul", "Dubai", "Istanbul", "Beijing", "Singapore",
            "Sydney", "Cairo", "Rio de Janeiro", "Toronto", "Bangkok"
        )
        val cityAdapter = CityAdapter(cityList)
        binding.rv.apply {
            adapter = cityAdapter
            layoutManager = LinearLayoutManager(this@Lesson20Task1)
        }
    }
}