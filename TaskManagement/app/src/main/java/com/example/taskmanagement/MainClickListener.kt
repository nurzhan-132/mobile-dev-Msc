package com.example.taskmanagement

interface MainClickListener {
    fun editTaskItem(taskItem: TaskModel)
    fun completeTaskItem(taskItem: TaskModel)
}