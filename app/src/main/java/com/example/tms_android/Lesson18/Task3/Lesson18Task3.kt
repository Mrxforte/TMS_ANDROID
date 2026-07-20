package com.example.tms_android.Lesson18.Task3

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.R

class Lesson18Task3 : AppCompatActivity() {

    private var currentFragmentTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson18_task3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnCatalog = findViewById<Button>(R.id.btnCatalog)
        val btnCart = findViewById<Button>(R.id.btnCart)

        btnHome.setOnClickListener { navigateTo("HOME") }
        btnCatalog.setOnClickListener { navigateTo("CATALOG") }
        btnCart.setOnClickListener { navigateTo("CART") }

        // Set initial fragment
        if (savedInstanceState == null) {
            navigateTo("HOME")
        }

        // Handle back button
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount <= 1) {
                    finish()
                } else {
                    supportFragmentManager.popBackStack()
                    // After pop, we need to update the UI
                    supportFragmentManager.executePendingTransactions()
                    val count = supportFragmentManager.backStackEntryCount
                    if (count > 0) {
                        val topEntry = supportFragmentManager.getBackStackEntryAt(count - 1)
                        topEntry.name?.let { tag ->
                            currentFragmentTag = tag
                            updateButtonColors(tag)
                        }
                    }
                }
            }
        })
    }

    private fun navigateTo(tag: String) {
        if (currentFragmentTag == tag) {
            Toast.makeText(this, getString(R.string.already_on_fragment), Toast.LENGTH_SHORT).show()
            return
        }

        val fragment = when (tag) {
            "HOME" -> HomeFragment()
            "CATALOG" -> CatalogFragment()
            "CART" -> CartFragment()
            else -> return
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .addToBackStack(tag)
            .commit()

        currentFragmentTag = tag
        updateButtonColors(tag)
    }

    private fun updateButtonColors(activeTag: String) {
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnCatalog = findViewById<Button>(R.id.btnCatalog)
        val btnCart = findViewById<Button>(R.id.btnCart)

        val activeColor = ContextCompat.getColor(this, R.color.btn_color)
        val inactiveColor = ContextCompat.getColor(this, R.color.gray)

        btnHome.setTextColor(if (activeTag == "HOME") activeColor else inactiveColor)
        btnCatalog.setTextColor(if (activeTag == "CATALOG") activeColor else inactiveColor)
        btnCart.setTextColor(if (activeTag == "CART") activeColor else inactiveColor)
    }
}
