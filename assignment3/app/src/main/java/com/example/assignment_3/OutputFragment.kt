package com.example.assignment_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.assignment_3.databinding.FragmentOutputBinding

class OutputFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels() // Access the shared ViewModel
    private lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        // Observe changes to the inputText LiveData and update TextView
        viewModel.inputText.observe(viewLifecycleOwner, { text ->
            binding.textViewOutput.text = text
        })

        return binding.root
    }
}
