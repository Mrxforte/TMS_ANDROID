package com.example.tms_android.Lessons.Lesson17.Task6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R

class Lesson17Task6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson17_task6)
        
        val mainView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contentLayer = findViewById<LinearLayout>(R.id.contentLayer)
        val loadingLayer = findViewById<LinearLayout>(R.id.loadingLayer)
        val downloadButton = findViewById<Button>(R.id.downloadButton)

        downloadButton.setOnClickListener {
            // Hide content and show loading
            contentLayer.visibility = View.GONE
            loadingLayer.visibility = View.VISIBLE

            // Imitate download for 3 seconds
            Handler(Looper.getMainLooper()).postDelayed({
                // After 3 seconds, show content again and hide loading
                loadingLayer.visibility = View.GONE
                contentLayer.visibility = View.VISIBLE
            }, 3000)
        }
    }
}
