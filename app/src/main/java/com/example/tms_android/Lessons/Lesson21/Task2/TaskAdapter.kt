package com.example.tms_android.Lessons.Lesson21.Task2

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class TaskAdapter(private val list: List<TaskModel>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskName: TextView = itemView.findViewById(R.id.taskName)
        private val taskDoneText: TextView = itemView.findViewById(R.id.taskDoneText)
        private val taskDoneCheckBox: CheckBox = itemView.findViewById(R.id.taskDoneCheckBox)

        fun bind(task: TaskModel) {
            taskName.text = task.taskName
            taskDoneCheckBox.setOnCheckedChangeListener(null)
            taskDoneCheckBox.isChecked = task.isDone
            
            updateUi(task.isDone)

            taskDoneCheckBox.setOnCheckedChangeListener { _, isChecked ->
                task.isDone = isChecked
                updateUi(isChecked)
            }
        }

        private fun updateUi(isDone: Boolean) {
            taskDoneText.text = if (isDone) "Done" else "Not Done"
            
            if (isDone) {
                taskName.paintFlags = taskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                taskName.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.darker_gray))
            } else {
                taskName.paintFlags = taskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                taskName.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            }
        }
    }
}
