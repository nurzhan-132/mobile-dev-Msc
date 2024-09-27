package com.example.instagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample Data
        val samplePosts = listOf(
            Post("https://via.placeholder.com/400", "Caption 1"),
            Post("https://via.placeholder.com/400", "Caption 2"),
            Post("https://via.placeholder.com/400", "Caption 3"),
            Post("https://via.placeholder.com/400", "Caption 4"),
            Post("https://via.placeholder.com/400", "Caption 5")
        )

        // Set up the adapter
        postAdapter = PostAdapter(samplePosts)
        recyclerView.adapter = postAdapter
    }
}
