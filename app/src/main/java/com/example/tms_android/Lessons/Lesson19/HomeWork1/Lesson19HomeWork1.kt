package com.example.tms_android.Lessons.Lesson19.HomeWork1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson19Homework1Binding

class Lesson19HomeWork1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson19Homework1Binding
    private lateinit var adapter: DynamicFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson19Homework1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = DynamicFragmentAdapter(this)
        binding.viewPager.adapter = adapter

        // Add first page
        adapter.addFragment("Page 1")

        binding.btnAddPage.setOnClickListener {
            val nextPageIndex = adapter.itemCount + 1
            adapter.addFragment("Page $nextPageIndex")
            // Automatically scroll to the new page
            binding.viewPager.currentItem = adapter.itemCount - 1
        }
    }
}
