package com.example.taskmanagement

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskItemDataAccess {
    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun allTaskItems(): Flow<List<TaskModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem: TaskModel)

    @Update
    suspend fun updateTaskItem(taskItem: TaskModel)

    @Delete
    suspend fun deleteTaskItem(taskItem: TaskModel)
}