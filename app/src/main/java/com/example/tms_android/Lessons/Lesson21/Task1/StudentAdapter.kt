package com.example.tms_android.Lessons.Lesson21.Task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class StudentAdapter(val studentsList: List<StudentModel>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        val student = studentsList[position]
        holder.tvName.text = student.name
        holder.tvRate.text = student.rate.toString()


        holder.itemView.findViewById<TextView>(R.id.rateButton).setOnClickListener {
            student.rate++
            holder.tvRate.text = student.rate.toString()
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.name)
        val tvRate: TextView = itemView.findViewById(R.id.rate)
    }
}