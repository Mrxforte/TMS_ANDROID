package com.example.tms_android.Lessons.Lesson20.Task1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android.databinding.CityItemBinding

class CityAdapter(private val cityList: List<String>) : RecyclerView.Adapter<CityAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cityName = cityList[position]
        holder.bind(cityName)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    class MyViewHolder(private val binding: CityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.cityName.text = title
        }
    }
}