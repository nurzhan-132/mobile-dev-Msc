// MainActivity.kt
package com.example.instagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var storiesRecyclerView: RecyclerView
    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var storiesAdapter: StoriesAdapter
    private lateinit var postsAdapter: PostsAdapter

    private val storiesList = listOf(
        Story(R.drawable.story_image_1, "User1"),
        Story(R.drawable.story_image_2, "User2"),
        Story(R.drawable.story_image_1, "User3"),
        Story(R.drawable.story_image_1, "User4"),
        Story(R.drawable.story_image_2, "User5")
    )

    private val postsList = listOf(
        Post("https://example.com/image1.jpg", "Caption 1"),
        Post("https://example.com/image2.jpg", "Caption 2"),
        Post("https://example.com/image3.jpg", "Caption 3"),
        Post("https://example.com/image4.jpg", "Caption 4"),
        Post("https://example.com/image5.jpg", "Caption 5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storiesRecyclerView = findViewById(R.id.storiesRecyclerView)
        postsRecyclerView = findViewById(R.id.postsRecyclerView)

        // Set up the stories RecyclerView
        storiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storiesAdapter = StoriesAdapter(storiesList)
        storiesRecyclerView.adapter = storiesAdapter

        // Set up the posts RecyclerView
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsAdapter = PostsAdapter(postsList)
        postsRecyclerView.adapter = postsAdapter
    }
}
