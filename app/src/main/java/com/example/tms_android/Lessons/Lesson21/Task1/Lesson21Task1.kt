package com.example.tms_android.Lessons.Lesson21.Task1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R


class Lesson21Task1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson21_task1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = listOf<StudentModel>(
            StudentModel("Jack", 2),
            StudentModel("Jane", 3),
            StudentModel("Jeny", 4),
            StudentModel("Harry", 2),
            StudentModel("Bob", 1),
            StudentModel("Cavin", 4),
            StudentModel("Liza", 6),
            StudentModel("Patrick", 1),
        )
        val adapter = StudentAdapter(list)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}
