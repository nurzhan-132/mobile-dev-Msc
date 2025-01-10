package com.example.taskmanagement

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainClickListener {
    private lateinit var binding: ActivityMainBinding

    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TaskManagementApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newTaskButton.setOnClickListener {
            TaskForm(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val mainActivity = this
        taskViewModel.taskItems.observe(this) {
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskRecyclerAdapter(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskModel) {
        TaskForm(taskItem).show(supportFragmentManager, "newTaskTag")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun completeTaskItem(taskItem: TaskModel) {
        taskViewModel.setCompleted(taskItem)
    }
}