package com.example.tms_android.Lesson18Task1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R

class Lesson18Task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson18_task1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val openProfileButton = findViewById<Button>(R.id.openProfileButton)

        openProfileButton.setOnClickListener {
            val name = usernameInput.text.toString().trim()
            val ageString = ageInput.text.toString().trim()

            if (name.isNotEmpty() && ageString.isNotEmpty()) {
                val age = ageString.toIntOrNull()
                if (age != null && age > 0) {
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("USER_NAME", name)
                    intent.putExtra("USER_AGE", age)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, R.string.invalid_input, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, R.string.invalid_input, Toast.LENGTH_SHORT).show()
            }
        }
    }
}