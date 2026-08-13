package com.example.tms_android.Lessons.Lesson30.Task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.Lessons.Lesson30.AppDatabase
import com.example.tms_android.Lessons.Lesson30.ProductEntity
import com.example.tms_android.databinding.ActivityLesson30Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Lesson30Task1 : AppCompatActivity() {

    private lateinit var binding: ActivityLesson30Binding
    private lateinit var db: AppDatabase
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLesson30Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = AppDatabase.getDatabase(this)
        setupRecyclerView()

        binding.fabAdd.setOnClickListener {
            addProduct()
        }

        loadProducts()
    }

    private fun setupRecyclerView() {
        adapter = ProductAdapter(emptyList())
        binding.rvProducts.adapter = adapter
    }

    private fun loadProducts() {
        lifecycleScope.launch {
            val products = withContext(Dispatchers.IO) {
                db.storeDao().getProducts()
            }
            adapter.updateProducts(products)
        }
    }

    private fun addProduct() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val newProduct = ProductEntity(
                    id = (0..Int.MAX_VALUE).random(),
                    title = "Product ${System.currentTimeMillis() % 1000}",
                    price = (10..100).random().toDouble(),
                    description = "Description",
                    category = "Category",
                    image = ""
                )
                db.storeDao().insertProduct(newProduct)
            }
            loadProducts()
        }
    }

    class ProductAdapter(private var products: List<ProductEntity>) :
        RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvName: TextView = view.findViewById(android.R.id.text1)
            val tvPrice: TextView = view.findViewById(android.R.id.text2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_2, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val product = products[position]
            holder.tvName.text = product.title
            holder.tvPrice.text = "$${product.price}"
        }

        override fun getItemCount() = products.size

        fun updateProducts(newProducts: List<ProductEntity>) {
            products = newProducts
            notifyDataSetChanged()
        }
    }
}
