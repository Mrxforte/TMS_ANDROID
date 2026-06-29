package com.example.tms_android.Lesson17TAsk2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R
import com.example.tms_android.R.string.load_image

class Lesson17Task2 : AppCompatActivity() {
    private var button: Button? = null
    private var image: ImageView? = null
    private var text: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson17_task2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
    }

    @SuppressLint("SetTextI18n")
    private fun loadUI() {
        button = findViewById<Button>(R.id.button)
        image = findViewById<ImageView>(R.id.iv_img)
        text = findViewById<TextView>(R.id.text)
        text?.textSize = 30f
        text?.text = "To see image tap the button"
        image?.visibility = View.INVISIBLE
        button?.setOnClickListener {
            if (button?.text?.toString() == button?.context?.getString(load_image)) {
                button?.text = button?.context?.getString(R.string.image_loaded)
                image?.visibility = View.VISIBLE
                text?.visibility = View.INVISIBLE

            } else {
                button?.text = button?.context?.getString(load_image)
                image?.visibility = View.INVISIBLE
                text?.visibility = View.VISIBLE
                text?.text = "To see image tap the button"
            }
        }
    }

}
