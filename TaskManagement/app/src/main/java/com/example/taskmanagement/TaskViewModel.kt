package com.example.taskmanagement

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalDate

class TaskViewModel(private val repository: TaskDataSource) : ViewModel() {
    val taskItems: LiveData<List<TaskModel>> = repository.allTaskItems.asLiveData()

    fun addTaskItem(taskItem: TaskModel) = viewModelScope.launch {
        repository.insertTaskItem(taskItem)
    }

    fun updateTaskItem(taskItem: TaskModel) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCompleted(taskItem: TaskModel) = viewModelScope.launch {
        if (!taskItem.isCompleted())
            taskItem.completedDateString = TaskModel.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }
}

class TaskItemModelFactory(private val repository: TaskDataSource) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}