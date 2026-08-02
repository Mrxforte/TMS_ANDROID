package com.example.tms_android.Lessons.Lesson22.Task2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tms_android.R

class Lesson22Task2 : AppCompatActivity() {
    val userViewModel by viewModels<UserViewModel>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson22_task2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        setupFilterLogic()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.rv)
        adapter = UserAdapter(emptyList())
        rv.adapter = adapter
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun setupFilterLogic() {
        val filterEditText = findViewById<EditText>(R.id.filterEditText)
        val filterButton = findViewById<Button>(R.id.filterButton)

        filterButton.setOnClickListener {
            val query = filterEditText.text.toString()
            userViewModel.filterUsers(query)
        }
    }

    private fun observeViewModel() {
        userViewModel.filteredUsers.observe(this, Observer { users ->
            adapter.setData(users)
        })
    }
}
