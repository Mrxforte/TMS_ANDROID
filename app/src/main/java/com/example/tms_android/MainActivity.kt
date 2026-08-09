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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.lessonsRecyclerView)
        val lessons = listOf(
            LessonModel(16, 6),
            LessonModel(17, 6),
            LessonModel(18, 3),
            LessonModel(19, 2),
            LessonModel(20, 6),
            LessonModel(21, 6),
            LessonModel(22, 6),
            LessonModel(23, 1),
            LessonModel(24, 5),
            LessonModel(25, 7),
            LessonModel(26, 6),
            LessonModel(27, 1)
        )
        recyclerView.adapter = LessonAdapter(lessons) { lessonModel ->
            val intent = Intent(this, LessonTasksActivity::class.java)
            intent.putExtra("LESSON_NUM", lessonModel.number)
            startActivity(intent)
        }
    }

    data class LessonModel(val number: Int, val taskCount: Int)

    class LessonAdapter(
        private val lessons: List<LessonModel>,
        private val onClick: (LessonModel) -> Unit
    ) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.lessonTitle)
            val subtitle: TextView = view.findViewById(R.id.lessonSubtitle)
            val badge: TextView = view.findViewById(R.id.taskCountBadge)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lesson, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val lesson = lessons[position]
            holder.title.text =
                holder.itemView.context.getString(R.string.lesson_name, lesson.number)
            holder.subtitle.text = holder.itemView.context.getString(R.string.android_dev)
            holder.badge.text =
                holder.itemView.context.getString(R.string.tasks_count, lesson.taskCount)
            holder.itemView.setOnClickListener { onClick(lesson) }
        }

        override fun getItemCount() = lessons.size
    }
}