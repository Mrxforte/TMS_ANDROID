package com.example.tms_android.Lessons.Lesson21.HomeWork2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.Lessons.Lesson21.PostModel
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson21Homework2Binding
import kotlin.random.Random

class Lesson21HomeWork2 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson21Homework2Binding
    private val adapter = PostAdapterHW2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson21Homework2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = adapter

        // 20dp spacing decoration
        val spacingPx = (20 * resources.displayMetrics.density).toInt()
        binding.rvPosts.addItemDecoration(SpacingItemDecoration(spacingPx))

        refreshList()

        binding.btnRefresh.setOnClickListener { refreshList() }
        binding.swipeRefresh.setOnRefreshListener {
            refreshList()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun refreshList() {
        val newList = generateRandomPosts()
        adapter.updateList(newList)
    }

    private fun generateRandomPosts(): List<PostModel> {
        val list = mutableListOf<PostModel>()
        val count = Random.nextInt(10, 20)
        for (i in 1..count) {
            when (Random.nextInt(3)) {
                0 -> list.add(PostModel.AuthorPost(i, "Author $i", "This is a random text for post $i"))
                1 -> list.add(PostModel.ImagePost(i, R.drawable.netflix, "Image caption for post $i"))
                2 -> list.add(PostModel.ButtonPost(i, "Click the button below for post $i", "Action $i"))
            }
        }
        return list.shuffled()
    }
}
