package com.example.tms_android.Lesson16.Task1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityLesson16Task1Binding

class Lesson16Task1 : AppCompatActivity() {

    lateinit var binding: ActivityLesson16Task1Binding
    var TAG = "Just running %s"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson16Task1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var textView = binding.textView.text

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onStart: ${binding.textView?.text}")
        var textView = binding.textView?.text = String.format(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onResume: ${binding.textView?.text}")
        var textView = binding.textView?.text = String.format(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onPause: ${binding.textView?.text}")
        var textView = binding.textView?.text = String.format(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onStop: ${binding.textView?.text}")
        var textView = binding.textView?.text = String.format(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onDestroy: ${binding.textView?.text}")
        var textView = binding.textView?.text = String.format(TAG, "onDestroy()")
    }

}