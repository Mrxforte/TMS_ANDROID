package com.example.tms_android.Lesson16.Task4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadUI()
    }

    private fun loadUI() {
        val name = intent.getStringExtra("name") ?: "N/A"
        val email = intent.getStringExtra("email") ?: "N/A"
        val pass = intent.getStringExtra("pass") ?: "N/A"

        binding.tvName.text = getString(R.string.profile_name_format, name)
        binding.tvEmail.text = getString(R.string.profile_email_format, email)
        binding.tvPassword.text = getString(R.string.profile_password_format, pass)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}