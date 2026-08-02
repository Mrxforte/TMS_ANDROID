package com.example.tms_android.Lessons.Lesson21.Task3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class StudentsAdapter(val list: MutableList<StudentsModel>) :
    RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_card, parent, false)
        return StudentsViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: StudentsViewHolder,
        position: Int
    ) {
        val student = list[position]
        holder.itemView.findViewById<TextView>(R.id.studentName).text = student.name
        holder.itemView.findViewById<TextView>(R.id.buttonDelete).text = "Delete"
        holder.itemView.findViewById<TextView>(R.id.buttonDelete).setOnClickListener {
            list.removeAt(position)
            Toast.makeText(holder.itemView.context, "Student deleted", Toast.LENGTH_SHORT).show()
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return if(list.isEmpty()) 1 else list.size
    }

    inner class StudentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}