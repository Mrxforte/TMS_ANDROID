package com.example.tms_android.Lessons.Lesson21.Task4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class SearchAdapter(val list: List<String>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private var filteredList: List<String> = list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.itemView.findViewById<TextView>(R.id.searchItem).text = filteredList[position]
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            list
        } else {
            list.filter { it.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }

    inner class SearchDiffCallback : DiffUtil.Callback<List<String>>() {
        override fun getOldListSize(): Int {

        }

        override fun getNewListSize(): Int {
            TODO("Not yet implemented")
        }

        override fun areItemsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            TODO("Not yet implemented")
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}