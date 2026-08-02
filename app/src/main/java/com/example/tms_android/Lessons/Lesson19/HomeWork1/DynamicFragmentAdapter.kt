package com.example.tms_android.Lessons.Lesson19.HomeWork1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tms_android.Lessons.Lesson19.Task2.TabFragment

class DynamicFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragments = mutableListOf<String>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return TabFragment.newInstance(fragments[position])
    }

    fun addFragment(title: String) {
        fragments.add(title)
        notifyItemInserted(fragments.size - 1)
    }
}
