package com.example.tms_android.Lessons.Lesson16.Task1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.databinding.ActivityLesson16Task1Binding

class Lesson16Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson16Task1Binding
    private val TAG_TEMPLATE = "Status: %s"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson16Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun updateStatus(method: String) {
        val message = String.format(TAG_TEMPLATE, method)
        Log.d("Lesson16Task1", message)
        binding.textView.text = message
        Toast.makeText(this, method, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        updateStatus("onStart()")
    }

    override fun onResume() {
        super.onResume()
        updateStatus("onResume()")
    }

    override fun onPause() {
        super.onPause()
        updateStatus("onPause()")
    }

    override fun onStop() {
        super.onStop()
        updateStatus("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lesson16Task1", "onDestroy() called")
        // Don't update UI in onDestroy as it might be unstable
    }
}