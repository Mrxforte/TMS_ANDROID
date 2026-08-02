package com.example.tms_android.Lessons.Lesson22.HomeWork1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.databinding.ActivityLesson22Homework1Binding

class Lesson22HomeWork1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson22Homework1Binding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson22Homework1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        setupListeners()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = NotesAdapter(
            onEditClick = { /* Not needed for HW1 */ },
            onDeleteClick = { /* Not needed for HW1 */ },
            showActions = false
        )
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.notesRecyclerView.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnAddNote.setOnClickListener {
            val text = binding.noteEditText.text.toString()
            if (text.isNotBlank()) {
                viewModel.addNote(text)
                binding.noteEditText.text?.clear()
            } else {
                Toast.makeText(this, "Please enter a note", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.notes.observe(this) { notes ->
            adapter.submitList(notes)
        }
    }
}
