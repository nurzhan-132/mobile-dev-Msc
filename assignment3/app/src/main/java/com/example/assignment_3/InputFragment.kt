package com.example.assignment_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.assignment_3.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels() // Access the shared ViewModel
    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)

        // Set up EditText input
        binding.btnSubmit.setOnClickListener {
            // Save the input text to ViewModel
            viewModel.inputText.value = binding.editTextInput.text.toString()
        }

        return binding.root
    }
}