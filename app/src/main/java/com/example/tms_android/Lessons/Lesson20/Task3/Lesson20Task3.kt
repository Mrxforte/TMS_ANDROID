package com.example.tms_android.Lessons.Lesson20.Task3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson20Task3Binding

class Lesson20Task3 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson20Task3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson20Task3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorList = listOf(
            ColorModel("Red", ContextCompat.getColor(this, R.color.red)),
            ColorModel("Green", ContextCompat.getColor(this, R.color.green)),
            ColorModel("Blue", ContextCompat.getColor(this, R.color.blue)),
            ColorModel("Yellow", ContextCompat.getColor(this, R.color.yellow)),
            ColorModel("Cyan", ContextCompat.getColor(this, R.color.cyan)),
            ColorModel("Magenta", ContextCompat.getColor(this, R.color.magenta)),
            ColorModel("Silver", ContextCompat.getColor(this, R.color.silver)),
            ColorModel("Maroon", ContextCompat.getColor(this, R.color.maroon)),
            ColorModel("Olive", ContextCompat.getColor(this, R.color.olive)),
            ColorModel("Dark Green", ContextCompat.getColor(this, R.color.dark_green)),
            ColorModel("Purple", ContextCompat.getColor(this, R.color.purple)),
            ColorModel("Teal", ContextCompat.getColor(this, R.color.teal)),
            ColorModel("Navy", ContextCompat.getColor(this, R.color.navy)),
            ColorModel("Orange", ContextCompat.getColor(this, R.color.orange)),
            ColorModel("Pink", ContextCompat.getColor(this, R.color.pink)),
            ColorModel("Brown", ContextCompat.getColor(this, R.color.brown)),
            ColorModel("Gold", ContextCompat.getColor(this, R.color.gold)),
            ColorModel("Beige", ContextCompat.getColor(this, R.color.beige)),
            ColorModel("Ivory", ContextCompat.getColor(this, R.color.ivory)),
            ColorModel("Sky Blue", ContextCompat.getColor(this, R.color.sky_blue))
        )

        val adapter = ColorsAdapter(colorList)
        binding.rvColors.adapter = adapter
        binding.rvColors.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)

    }
}