package com.example.taskmanagement

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TaskDataSource(private val taskItemDao: TaskItemDataAccess)
{
    val allTaskItems: Flow<List<TaskModel>> = taskItemDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskModel)
    {
        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskModel)
    {
        taskItemDao.updateTaskItem(taskItem)
    }
}