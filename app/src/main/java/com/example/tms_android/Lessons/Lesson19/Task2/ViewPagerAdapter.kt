package com.example.tms_android.Lessons.Lesson19.Task2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity, private val tabs: List<String>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment {
        return TabFragment.newInstance(tabs[position])
    }
}
