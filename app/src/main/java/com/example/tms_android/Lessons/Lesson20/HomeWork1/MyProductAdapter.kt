package com.example.tms_android.Lessons.Lesson20.HomeWork1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.MyProdContainerBinding

class MyProductAdapter(
    private val list: MutableList<MyProductModel>,
    private val onProductClick: (Int) -> Unit
) : RecyclerView.Adapter<MyProductAdapter.MyProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductViewHolder {
        val binding = MyProdContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class MyProductViewHolder(private val binding: MyProdContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onProductClick(position)
                }
            }
        }

        fun bind(product: MyProductModel) {
            binding.productTitle.text = product.title
            binding.productCount.text = product.count.toString()
        }
    }
}