package com.example.tms_android.Lessons.Lesson20.Task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.MovieCardBinding

class MovieAdapter(private val movieList: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MyMovieViewHolder>() {

    class MyMovieViewHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.movieTitle.text = movie.title
        holder.binding.movieYear.text = movie.year.toString()
        holder.binding.movieImage.setImageResource(movie.imageResId)
    }

    override fun getItemCount(): Int = movieList.size
}
