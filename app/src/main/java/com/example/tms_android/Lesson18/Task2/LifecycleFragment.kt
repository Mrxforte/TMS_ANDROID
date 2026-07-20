package com.example.tms_android.Lesson18.Task2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tms_android.R

class LifecycleFragment : Fragment() {

    private val TAG = "LifecycleFragment"
    private var statusTextView: TextView? = null
    private var logcatInfoTextView: TextView? = null
    private val logBuilder = StringBuilder()

    private fun updateLifecycle(methodName: String) {
        statusTextView?.text = getString(R.string.current_state, methodName)
        
        val logEntry = "$methodName\n"
        logBuilder.insert(0, logEntry) // Newest on top
        logcatInfoTextView?.text = logBuilder.toString()
        
        // Pretty logging to Logcat
        Log.d(TAG, "================================")
        Log.d(TAG, ">> FRAGMENT LIFECYCLE EVENT <<")
        Log.d(TAG, "Method: $methodName")
        Log.d(TAG, "================================")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        updateLifecycle("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateLifecycle("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lifecycle, container, false)
        statusTextView = view.findViewById(R.id.lifecycleStatusText)
        logcatInfoTextView = view.findViewById(R.id.logcatHintText)
        
        updateLifecycle("onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateLifecycle("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        updateLifecycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        updateLifecycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        updateLifecycle("onPause")
    }

    override fun onStop() {
        super.onStop()
        updateLifecycle("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        updateLifecycle("onDestroyView")
        statusTextView = null
        logcatInfoTextView = null
    }

    override fun onDestroy() {
        super.onDestroy()
        updateLifecycle("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        updateLifecycle("onDetach")
    }
}
