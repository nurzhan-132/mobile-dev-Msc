package com.example.assignment_3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HelloFragment", "onCreateView called")
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
    override fun onStart() {
        super.onStart()
        Log.d("HelloFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.d("HelloFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.d("HelloFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.d("HelloFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("HelloFragment", "onDestroyView called")
    }
}