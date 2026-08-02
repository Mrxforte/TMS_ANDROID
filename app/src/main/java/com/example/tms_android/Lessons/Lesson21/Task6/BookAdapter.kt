package com.example.tms_android.Lessons.Lesson21.Task6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.R

class BookAdapter(private val allBooks: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var filteredList = allBooks

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.bookTitle)
        val author: TextView = view.findViewById(R.id.bookAuthor)
        val genre: TextView = view.findViewById(R.id.bookGenre)
        val year: TextView = view.findViewById(R.id.bookYear)
        val status: TextView = view.findViewById(R.id.bookStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = filteredList[position]
        holder.title.text = book.title
        holder.author.text = book.author
        holder.genre.text = book.genre
        holder.year.text = book.year.toString()
        holder.status.text = if (book.isRead) "Read" else "Not Read"
    }

    override fun getItemCount() = filteredList.size

    fun filter(query: String?) {
        filteredList = if (query.isNullOrBlank()) {
            allBooks
        } else {
            allBooks.filter {
                it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    fun sortTitle() {
        filteredList = filteredList.sortedBy { it.title }
        notifyDataSetChanged()
    }

    fun sortAuthor() {
        filteredList = filteredList.sortedBy { it.author }
        notifyDataSetChanged()
    }

    fun sortYear() {
        filteredList = filteredList.sortedBy { it.year }
        notifyDataSetChanged()
    }
}
