package com.example.tms_android.Lessons.Lesson18.Task2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(/* context = */ activity) {
    override fun createFragment(p0: Int): Fragment {
        return LifecycleFragment()
    }

    override fun getItemCount(): Int {
        return 10
    }

}