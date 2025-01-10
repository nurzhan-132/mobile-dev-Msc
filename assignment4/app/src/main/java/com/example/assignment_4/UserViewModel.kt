package com.example.assignment_4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository
    val allUsers: LiveData<List<User>>

    val userLiveData = MutableLiveData<UserResponse>()

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        allUsers = userRepository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun update(user: User) = viewModelScope.launch {
        userRepository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        userRepository.delete(user)
    }

    fun getUser(userId: Int) {
        viewModelScope.launch {
            try {
                val user = userRepository.getUser(userId)
                userLiveData.postValue(user)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
