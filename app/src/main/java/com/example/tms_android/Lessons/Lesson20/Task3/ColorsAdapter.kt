package com.example.tms_android.Lessons.Lesson20.Task3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tms_android.databinding.ColorCardBinding

@Suppress("REDUNDANT_CALL_OF_CONVERSION_METHOD")
class ColorsAdapter(val list: List<ColorModel>) :
    RecyclerView.Adapter<ColorsAdapter.MyColorViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyColorViewHolder {
        val binding = ColorCardBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MyColorViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: MyColorViewHolder,
        p1: Int
    ) {
        val colors = list[p1]
        val title = colors.colorName
        val bgColor = colors.colorId
        p0.binding.textView4.text = title
        p0.binding.colorCard.setBackgroundColor(bgColor)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyColorViewHolder(val binding: ColorCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}
