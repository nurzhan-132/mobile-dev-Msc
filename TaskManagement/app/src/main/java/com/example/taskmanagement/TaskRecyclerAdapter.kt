package com.example.taskmanagement

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanagement.databinding.TaskItemBinding

class TaskRecyclerAdapter(
    private val taskItems: List<TaskModel>,
    private val clickListener: MainClickListener
) : RecyclerView.Adapter<TaskItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemBinding.inflate(from, parent, false)
        return TaskItemHolder(parent.context, binding, clickListener)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskItemHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }

    override fun getItemCount(): Int = taskItems.size
}