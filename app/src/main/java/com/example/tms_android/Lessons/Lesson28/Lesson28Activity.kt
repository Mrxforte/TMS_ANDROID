package com.example.tms_android.Lessons.Lesson28

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tms_android.databinding.ActivityLesson28Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lesson28Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLesson28Binding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson28Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()

        binding.btnFetchProducts.setOnClickListener {
            fetchProducts()
        }
    }

    private fun setupRecyclerView() {
        adapter = ProductAdapter(emptyList())
        binding.rvProducts.adapter = adapter
    }

    private fun fetchProducts() {
        RetrofitInstance.api.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body() ?: emptyList()
                    adapter.updateProducts(products)
                } else {
                    Toast.makeText(this@Lesson28Activity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@Lesson28Activity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
