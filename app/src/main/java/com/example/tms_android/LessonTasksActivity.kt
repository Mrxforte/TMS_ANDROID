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
import com.example.tms_android.Lessons.Lesson16.Task1.Lesson16Task1
import com.example.tms_android.Lessons.Lesson16.Task2.Lesson16Task2
import com.example.tms_android.Lessons.Lesson16.Task3.Lesson16Task3
import com.example.tms_android.Lessons.Lesson16.Task4.Lesson16Task4
import com.example.tms_android.Lessons.Lesson16.Task5.Lesson16Task5
import com.example.tms_android.Lessons.Lesson16.Task6.Lesson16Task6
import com.example.tms_android.Lessons.Lesson17.Task1.Lesson17Task1
import com.example.tms_android.Lessons.Lesson17.Task2.Lesson17Task2
import com.example.tms_android.Lessons.Lesson17.Task3.Lesson17Task3
import com.example.tms_android.Lessons.Lesson17.Task4.Lesson17Task4
import com.example.tms_android.Lessons.Lesson17.Task5.Lesson17Task5
import com.example.tms_android.Lessons.Lesson17.Task6.Lesson17Task6
import com.example.tms_android.Lessons.Lesson18.Task1.Lesson18Task1
import com.example.tms_android.Lessons.Lesson18.Task2.Lesson18Task2
import com.example.tms_android.Lessons.Lesson18.Task3.Lesson18Task3
import com.example.tms_android.Lessons.Lesson19.Task1.Lesson19Task1
import com.example.tms_android.Lessons.Lesson19.Task2.Lesson19Task2
import com.example.tms_android.Lessons.Lesson19.HomeWork1.Lesson19HomeWork1
import com.example.tms_android.Lessons.Lesson19.HomeWork2.Lesson19HomeWork2
import com.example.tms_android.Lessons.Lesson20.HomeWork1.Lesson20HomeWork1
import com.example.tms_android.Lessons.Lesson20.HomeWork2.Lesson20HomeWork2
import com.example.tms_android.Lessons.Lesson20.Task1.Lesson20Task1
import com.example.tms_android.Lessons.Lesson20.Task2.Lesson20Task2
import com.example.tms_android.Lessons.Lesson20.Task3.Lesson20Task3
import com.example.tms_android.Lessons.Lesson20.Task4.Lesson20Task4
import com.example.tms_android.Lessons.Lesson21.Task1.Lesson21Task1
import com.example.tms_android.Lessons.Lesson21.Task2.Lesson21Task2
import com.example.tms_android.Lessons.Lesson21.Task3.Lesson21Task3
import com.example.tms_android.Lessons.Lesson21.Task4.Lesson21Task4
import com.example.tms_android.Lessons.Lesson21.Task5.Lesson21Task5
import com.example.tms_android.Lessons.Lesson21.Task6.Lesson21Task6
import com.example.tms_android.Lessons.Lesson21.HomeWork1.Lesson21HomeWork1
import com.example.tms_android.Lessons.Lesson21.HomeWork2.Lesson21HomeWork2
import com.example.tms_android.Lessons.Lesson22.Task1.Lesson22Task1
import com.example.tms_android.Lessons.Lesson22.Task2.Lesson22Task2
import com.example.tms_android.Lessons.Lesson22.Task3.Lesson22Task3
import com.example.tms_android.Lessons.Lesson24.HomeWork1.Lesson24HomeWork1
import com.example.tms_android.Lessons.Lesson24.Task3.Lesson24Task3
import com.example.tms_android.Lessons.Lesson24.Task4.Lesson24Task4
import com.example.tms_android.Lessons.Lesson24.Task5.Lesson24Task5
import com.example.tms_android.Lessons.Lesson24.Task6.Lesson24Task6
import com.example.tms_android.Lessons.Lesson26.Task1.Lesson26Task1
import com.example.tms_android.Lessons.Lesson27.Task1.Lesson27Task1

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
            16 -> listOf(1, 2, 3, 4, 5, 6)
            17 -> (1..6).toList()
            18 -> listOf(1, 2, 3)
            19 -> listOf(1, 2, 3, 4)
            20 -> listOf(1, 2, 3, 4, 5, 6)
            21 -> listOf(1, 2, 3, 4, 5, 6, 7, 8)
            22 -> listOf(1, 2, 3, 4, 5, 6)
            24 -> listOf(3, 4, 5, 6, 7)
            26 -> listOf(1)
            27 -> listOf(1)
            else -> emptyList()
        }

        if (tasks.isNotEmpty()) {
            recyclerView.visibility = View.VISIBLE
            comingSoonText.visibility = View.GONE
            recyclerView.adapter = TaskAdapter(tasks) { taskNum ->
                val activityClass = when (lessonNum) {
                    16 -> when (taskNum) {
                        1 -> Lesson16Task1::class.java
                        2 -> Lesson16Task2::class.java
                        3 -> Lesson16Task3::class.java
                        4 -> Lesson16Task4::class.java
                        5 -> Lesson16Task5::class.java
                        6 -> Lesson16Task6::class.java
                        else -> null
                    }

                    17 -> when (taskNum) {
                        1 -> Lesson17Task1::class.java
                        2 -> Lesson17Task2::class.java
                        3 -> Lesson17Task3::class.java
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

                    19 -> when (taskNum) {
                        1 -> Lesson19Task1::class.java
                        2 -> Lesson19Task2::class.java
                        3 -> Lesson19HomeWork1::class.java
                        4 -> Lesson19HomeWork2::class.java
                        else -> null
                    }

                    20 -> when (taskNum) {
                        1 -> Lesson20Task1::class.java
                        2 -> Lesson20Task2::class.java
                        3 -> Lesson20Task3::class.java
                        4 -> Lesson20Task4::class.java
                        5 -> Lesson20HomeWork1::class.java
                        6 -> Lesson20HomeWork2::class.java
                        else -> null
                    }

                    21 -> when (taskNum) {
                        1 -> Lesson21Task1::class.java
                        2 -> Lesson21Task2::class.java
                        3 -> Lesson21Task3::class.java
                        4 -> Lesson21Task4::class.java
                        5 -> Lesson21Task5::class.java
                        6 -> Lesson21Task6::class.java
                        7 -> Lesson21HomeWork1::class.java
                        8 -> Lesson21HomeWork2::class.java
                        else -> null
                    }

                    22 -> when (taskNum) {
                        1 -> Lesson22Task1::class.java
                        2 -> Lesson22Task2::class.java
                        3 -> Lesson22Task3::class.java
                        else -> null
                    }

                    24 -> when (taskNum) {
                        3 -> Lesson24Task3::class.java
                        4 -> Lesson24Task4::class.java
                        5 -> Lesson24Task5::class.java
                        6 -> Lesson24Task6::class.java
                        7 -> Lesson24HomeWork1::class.java
                        else -> null
                    }

                    26 -> when (taskNum) {
                        1 -> Lesson26Task1::class.java
                        else -> null
                    }

                    27 -> when (taskNum) {
                        1 -> Lesson27Task1::class.java
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
