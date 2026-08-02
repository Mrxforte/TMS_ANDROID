package com.example.tms_android.Lessons.Lesson20.HomeWork2

import android.annotation.SuppressLint
import com.example.tms_android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmptyScreenAdapter(val list: List<String>) :
    RecyclerView.Adapter<EmptyScreenAdapter.EmptyScreenViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmptyScreenViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.empty_screen_item, parent, false)
        return EmptyScreenViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: EmptyScreenViewHolder,
        position: Int
    ) {
        if (list.isEmpty()) {
            holder.emptyText.text = "No data"
        } else {
            holder.emptyText.text = list[position]
        }
    }

    override fun getItemCount(): Int {
        return if (list.isEmpty()) 1 else list.size
    }

    class EmptyScreenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emptyText: TextView = itemView.findViewById(R.id.emptyText)
    }
}