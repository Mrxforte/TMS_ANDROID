package com.example.tms_android.Lessons.Lesson22.HomeWork1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.ItemNoteBinding
import java.text.SimpleDateFormat
import java.util.Locale

class NotesAdapter(
    private val onEditClick: (NoteModel) -> Unit,
    private val onDeleteClick: (NoteModel) -> Unit,
    private val showActions: Boolean = true
) : ListAdapter<NoteModel, NotesAdapter.NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        fun bind(note: NoteModel) {
            binding.noteText.text = note.text
            binding.noteDate.text = dateFormat.format(note.date)

            binding.btnEdit.visibility = if (showActions) View.VISIBLE else View.GONE
            binding.btnDelete.visibility = if (showActions) View.VISIBLE else View.GONE

            binding.btnEdit.setOnClickListener { onEditClick(note) }
            binding.btnDelete.setOnClickListener { onDeleteClick(note) }
        }
    }

    class NoteDiffCallback : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }
}
