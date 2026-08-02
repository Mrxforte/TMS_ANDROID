package com.example.tms_android.Lessons.Lesson22.HomeWork3

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.Lessons.Lesson22.HomeWork1.Lesson22HomeWork1
import com.example.tms_android.Lessons.Lesson22.HomeWork1.NoteModel
import com.example.tms_android.Lessons.Lesson22.HomeWork1.NotesAdapter
import com.example.tms_android.Lessons.Lesson22.HomeWork1.NotesViewModel
import com.example.tms_android.databinding.ActivityLesson22Homework1Binding

class Lesson22HomeWork3 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson22Homework1Binding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Reusing the same layout as HW1
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
            onEditClick = { note -> showEditDialog(note) },
            onDeleteClick = { note -> viewModel.deleteNote(note.id) },
            showActions = true
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

    private fun showEditDialog(note: NoteModel) {
        val editText = EditText(this)
        editText.setText(note.text)
        
        AlertDialog.Builder(this)
            .setTitle("Edit Note")
            .setView(editText)
            .setPositiveButton("Save") { _, _ ->
                val newText = editText.text.toString()
                if (newText.isNotBlank()) {
                    viewModel.updateNote(note.id, newText)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
