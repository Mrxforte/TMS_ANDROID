package com.example.tms_android.Lessons.Lesson21.Task6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.databinding.ActivityLesson21Task6Binding

class Lesson21Task6 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson21Task6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson21Task6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val allBooks = listOf(
            Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, true),
            Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, false),
            Book(3, "1984", "George Orwell", "Dystopian", 1949, true),
            Book(4, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951, false),
            Book(5, "Brave New World", "Aldous Huxley", "Dystopian", 1932, true),
            Book(6, "Animal Farm", "George Orwell", "Satire", 1945, true),
            Book(7, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, false),
            Book(8, "Fahrenheit 451", "Ray Bradbury", "Dystopian", 1953, true)
        )

        val adapter = BookAdapter(allBooks)
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.bookRecyclerView.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText)
                return true
            }
        })

        binding.btnSortTitle.setOnClickListener { adapter.sortTitle() }
        binding.btnSortAuthor.setOnClickListener { adapter.sortAuthor() }
        binding.btnSortYear.setOnClickListener { adapter.sortYear() }
    }
}
