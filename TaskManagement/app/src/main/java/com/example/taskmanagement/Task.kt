package com.example.taskmanagement

import java.util.Date

data class Task(
    var id: Int,
    var title: String,
    var desc: String,
    var createdAt: Date,
    var isCompleted: Boolean
)
