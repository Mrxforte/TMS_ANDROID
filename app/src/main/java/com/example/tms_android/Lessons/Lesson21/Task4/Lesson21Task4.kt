package com.example.tms_android.Lessons.Lesson21.Task4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson21Task4Binding

class Lesson21Task4 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson21Task4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson21Task4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = SearchAdapter(listOf("item1", "item2", "item3", "item4", "item5", "item6"))
        binding.rv.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        binding.searchEditText.addTextChangedListener {
            adapter.filter(it.toString())
        }
        binding.rv.layoutManager = layoutManager

    }
}