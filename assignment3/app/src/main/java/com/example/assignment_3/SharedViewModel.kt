package com.example.assignment_3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    // LiveData to hold the input text
    val inputText = MutableLiveData<String>()
}