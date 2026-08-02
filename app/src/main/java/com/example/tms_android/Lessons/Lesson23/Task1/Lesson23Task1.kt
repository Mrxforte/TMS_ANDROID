package com.example.tms_android.Lessons.Lesson23.Task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.databinding.ActivityLesson23Task1Binding

class Lesson23Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson23Task1Binding
    private val viewModel: ShoppingViewModel by viewModels()
    private lateinit var adapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson23Task1Binding.inflate(layoutInflater)
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
        adapter = ShoppingAdapter { item ->
            viewModel.toggleItem(item.id)
        }
        binding.shoppingRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.shoppingRecyclerView.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            val name = binding.shoppingEditText.text.toString()
            if (name.isNotBlank()) {
                viewModel.addItem(name)
                binding.shoppingEditText.text.clear()
            } else {
                Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.items.observe(this) { items ->
            adapter.submitList(items)
        }
    }
}
