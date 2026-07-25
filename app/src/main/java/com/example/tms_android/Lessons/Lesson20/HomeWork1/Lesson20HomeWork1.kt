package com.example.tms_android.Lessons.Lesson20.HomeWork1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android.databinding.ActivityLesson20HomeWork1Binding

class Lesson20HomeWork1 : AppCompatActivity() {
    private lateinit var binding: ActivityLesson20HomeWork1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson20HomeWork1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myProdList = mutableListOf(
            MyProductModel("Nike Air Max", 5),
            MyProductModel("Adidas Ultraboost", 3),
            MyProductModel("Puma RS-X", 10),
            MyProductModel("Reebok Nano", 2),
            MyProductModel("New Balance 574", 7),
            MyProductModel("Asics Kayano", 4),
            MyProductModel("Under Armour Curry", 6),
            MyProductModel("Vans Old Skool", 12),
            MyProductModel("Converse Chuck Taylor", 8),
            MyProductModel("Skechers D'Lites", 1)
        )

        val productAdapter = MyProductAdapter(myProdList) { position ->
            // Improvement: Deleting item on click
            val deletedItem = myProdList[position]
            myProdList.removeAt(position)
            binding.myRecyclerView.adapter?.notifyItemRemoved(position)
            Toast.makeText(this, "Deleted: ${deletedItem.title}", Toast.LENGTH_SHORT).show()
        }

        binding.myRecyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@Lesson20HomeWork1)
        }

        binding.fabAddProduct.setOnClickListener {
            // Improvement: Adding a new product correctly
            val newProduct = MyProductModel("New Item #${myProdList.size + 1}", (1..20).random())
            myProdList.add(0, newProduct) // Add to top
            productAdapter.notifyItemInserted(0)
            binding.myRecyclerView.scrollToPosition(0)
        }
    }
}