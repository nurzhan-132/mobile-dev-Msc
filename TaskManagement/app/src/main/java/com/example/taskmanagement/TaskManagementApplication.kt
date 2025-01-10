package com.example.taskmanagement

import android.app.Application

class TaskManagementApplication : Application()
{
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { TaskDataSource(database.taskItemDao()) }
}