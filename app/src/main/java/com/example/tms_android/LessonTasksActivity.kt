package com.example.tms_android

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.Lesson17TAsk1.Lesson17Task1
import com.example.tms_android.Lesson17TAsk2.Lesson17Task2
import com.example.tms_android.Lesson17TAsk3.Lesson17TAsk3
import com.example.tms_android.Lesson17Task4.Lesson17Task4
import com.example.tms_android.Lesson17Task5.Lesson17Task5
import com.example.tms_android.Lesson17Task6.Lesson17Task6
import com.example.tms_android.Lesson18Task1.Lesson18Task1
import com.example.tms_android.Lesson18Task2.Lesson18Task2
import com.example.tms_android.Lesson18Task3.Lesson18Task3

class LessonTasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson_tasks)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lessonNum = intent.getIntExtra("LESSON_NUM", 17)
        title = getString(R.string.lesson_name, lessonNum)

        val recyclerView = findViewById<RecyclerView>(R.id.tasksRecyclerView)
        val comingSoonText = findViewById<TextView>(R.id.comingSoonText)

        val tasks = when (lessonNum) {
            17 -> (1..6).toList()
            18 -> listOf(1, 2, 3)
            else -> emptyList()
        }

        if (tasks.isNotEmpty()) {
            recyclerView.visibility = View.VISIBLE
            comingSoonText.visibility = View.GONE
            recyclerView.adapter = TaskAdapter(tasks) { taskNum ->
                val activityClass = when (lessonNum) {
                    17 -> when (taskNum) {
                        1 -> Lesson17Task1::class.java
                        2 -> Lesson17Task2::class.java
                        3 -> Lesson17TAsk3::class.java
                        4 -> Lesson17Task4::class.java
                        5 -> Lesson17Task5::class.java
                        6 -> Lesson17Task6::class.java
                        else -> null
                    }
                    18 -> when (taskNum) {
                        1 -> Lesson18Task1::class.java
                        2 -> Lesson18Task2::class.java
                        3 -> Lesson18Task3::class.java
                        else -> null
                    }
                    else -> null
                }
                activityClass?.let {
                    startActivity(Intent(this, it))
                }
            }
        } else {
            recyclerView.visibility = View.GONE
            comingSoonText.visibility = View.VISIBLE
        }
    }

    class TaskAdapter(
        private val tasks: List<Int>,
        private val onClick: (Int) -> Unit
    ) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.taskTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_task, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val taskNum = tasks[position]
            holder.title.text = holder.itemView.context.getString(R.string.task_name, taskNum)
            holder.itemView.setOnClickListener { onClick(taskNum) }
        }

        override fun getItemCount() = tasks.size
    }
}