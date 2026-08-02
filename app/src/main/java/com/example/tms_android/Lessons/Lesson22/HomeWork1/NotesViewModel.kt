package com.example.tms_android.Lessons.Lesson22.HomeWork1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date

class NotesViewModel : ViewModel() {
    private val _notes = MutableLiveData<List<NoteModel>>(emptyList())
    val notes: LiveData<List<NoteModel>> = _notes

    fun addNote(text: String) {
        val currentList = _notes.value.orEmpty().toMutableList()
        val newNote = NoteModel(
            id = System.currentTimeMillis(),
            text = text,
            date = Date()
        )
        currentList.add(0, newNote)
        _notes.value = currentList
    }

    fun deleteNote(id: Long) {
        val currentList = _notes.value.orEmpty().toMutableList()
        currentList.removeAll { it.id == id }
        _notes.value = currentList
    }

    fun updateNote(id: Long, newText: String) {
        val currentList = _notes.value.orEmpty().toMutableList()
        val index = currentList.indexOfFirst { it.id == id }
        if (index != -1) {
            val updatedNote = currentList[index].copy(text = newText)
            currentList[index] = updatedNote
            _notes.value = currentList
        }
    }
}
