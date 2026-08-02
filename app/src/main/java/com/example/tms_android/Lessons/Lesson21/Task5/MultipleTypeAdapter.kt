package com.example.tms_android.Lessons.Lesson21.Task5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class MultipleTypeAdapter(val list: List<MultipleType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_CONTENT = 1
        const val TYPE_BUTTON = 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.multiple_type_item, parent, false)
        return MultipleTypeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val headerView = holder.itemView.findViewById<TextView>(R.id.header)
        val contentView = holder.itemView.findViewById<TextView>(R.id.content)
        val buttonView = holder.itemView.findViewById<Button>(R.id.button)

        // Hide all views first
        headerView.visibility = View.GONE
        contentView.visibility = View.GONE
        buttonView.visibility = View.GONE

        val item = list[position]
        when (item) {
            is MultipleType.Header -> {
                headerView.visibility = View.VISIBLE
                headerView.text = item.header
            }

            is MultipleType.Content -> {
                contentView.visibility = View.VISIBLE
                contentView.text = item.content
            }

            is MultipleType.Button -> {
                buttonView.visibility = View.VISIBLE
                buttonView.text = item.button
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is MultipleType.Header -> TYPE_HEADER
            is MultipleType.Content -> TYPE_CONTENT
            is MultipleType.Button -> TYPE_BUTTON
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MultipleTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}