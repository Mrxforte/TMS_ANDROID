package com.example.tms_android.Lessons.Lesson21.Task5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson21Task5Binding

class Lesson21Task5 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson21Task5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson21Task5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = listOf<MultipleType>(
            MultipleType.Header("Header 1"),
            MultipleType.Content("Content 1"),
            MultipleType.Button("Button 1"),
            MultipleType.Header("Header 2"),
            MultipleType.Content("Content 2"),
            MultipleType.Button("Button 2"),
            MultipleType.Header("Header 3"),
            MultipleType.Content("Content 3"),
            MultipleType.Button("Button 3"),
            MultipleType.Header("Header 4"),
            MultipleType.Content("Content 4"),
            MultipleType.Button("Button 4"),
            MultipleType.Header("Header 5"),
            MultipleType.Content("Content 5"),
            MultipleType.Button("Button 5"),
            MultipleType.Header("Header 6"),
            MultipleType.Content("Content 6"),
            MultipleType.Button("Button 6"),
            MultipleType.Header("Header 7"),
            MultipleType.Content("Content 7"),
            MultipleType.Button("Button 7"),
            MultipleType.Header("Header 8"),
            MultipleType.Content("Content 8"),
        )

        val adapter = MultipleTypeAdapter(list)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}
