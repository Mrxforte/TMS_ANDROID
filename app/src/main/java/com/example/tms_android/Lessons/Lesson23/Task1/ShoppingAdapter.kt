package com.example.tms_android.Lessons.Lesson23.Task1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.ItemShoppingBinding

class ShoppingAdapter(
    private val onCheckedChange: (ShoppingItem) -> Unit
) : ListAdapter<ShoppingItem, ShoppingAdapter.ShoppingViewHolder>(ShoppingDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ShoppingViewHolder(private val binding: ItemShoppingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoppingItem) {
            binding.itemName.text = item.name
            
            // Remove listener before setting check to avoid recursion
            binding.itemCheckbox.setOnCheckedChangeListener(null)
            binding.itemCheckbox.isChecked = item.isChecked
            
            binding.itemCheckbox.setOnCheckedChangeListener { _, _ ->
                onCheckedChange(item)
            }
        }
    }

    class ShoppingDiffCallback : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem == newItem
        }
    }
}
