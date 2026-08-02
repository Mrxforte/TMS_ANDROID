package com.example.tms_android.Lessons.Lesson19.Task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tms_android.R

class TabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("TITLE") ?: "Unknown"
        view.findViewById<TextView>(R.id.tabText).text = title
    }

    companion object {
        fun newInstance(title: String): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putString("TITLE", title)
            fragment.arguments = args
            return fragment
        }
    }
}
