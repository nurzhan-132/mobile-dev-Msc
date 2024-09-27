package com.example.instagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoriesAdapter(private val stories: List<Story>) : RecyclerView.Adapter<StoriesAdapter.StoryViewHolder>() {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val storyImageView: ImageView = view.findViewById(R.id.storyImageView)
        val storyNameTextView: TextView = view.findViewById(R.id.storyNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.storyImageView.setImageResource(story.imageResId) // Assuming you have drawable resources
        holder.storyNameTextView.text = story.name
    }

    override fun getItemCount(): Int = stories.size
}
