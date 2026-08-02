package com.example.tms_android.Lessons.Lesson19.HomeWork2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson19Homework2Binding
import com.google.android.material.snackbar.Snackbar

class Lesson19HomeWork2 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson19Homework2Binding
    private var deletedText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson19Homework2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnDelete.setOnClickListener {
            if (binding.textView.text.isNotEmpty()) {
                deletedText = binding.textView.text.toString()
                binding.textView.text = ""

                Snackbar.make(binding.root, "Content deleted", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        binding.textView.text = deletedText
                    }.show()
            } else {
                Snackbar.make(binding.root, "Nothing to delete", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
