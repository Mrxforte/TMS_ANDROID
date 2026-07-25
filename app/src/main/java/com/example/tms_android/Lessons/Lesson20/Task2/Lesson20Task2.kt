package com.example.tms_android.Lessons.Lesson20.Task2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson20Task2Binding

class Lesson20Task2 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson20Task2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson20Task2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadUI()
    }

    private fun loadUI() {
        val movies = listOf(
            MovieModel("Inception", 2010, R.drawable.netflix),
            MovieModel("The Dark Knight", 2008, R.drawable.netflix),
            MovieModel("Interstellar", 2014, R.drawable.netflix),
            MovieModel("The Matrix", 1999, R.drawable.netflix),
            MovieModel("Gladiator", 2000, R.drawable.netflix),
            MovieModel("The Godfather", 1972, R.drawable.netflix),
            MovieModel("Pulp Fiction", 1994, R.drawable.netflix),
            MovieModel("The Shawshank Redemption", 1994, R.drawable.netflix),
            MovieModel("Joker", 2019, R.drawable.netflix),
            MovieModel("Avengers: Endgame", 2019, R.drawable.netflix)
        )

        var adapter = MovieAdapter(movies)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.movieRv.adapter = adapter
        binding.movieRv.layoutManager = linearLayoutManager
    }
}
