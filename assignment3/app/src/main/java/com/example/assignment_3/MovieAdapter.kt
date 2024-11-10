package com.example.assignment_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder class holds references to the views of each item
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieDescription: TextView = itemView.findViewById(R.id.movieDescription)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    // Called to create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    // Called to bind data to each item in the RecyclerView
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]

        // Set the data to the views
        holder.movieTitle.text = currentMovie.title
        holder.movieDescription.text = currentMovie.description

        // Set an onClickListener for the cardView
        holder.cardView.setOnClickListener {
            // Display a Toast with the clicked movie's name
            Toast.makeText(context, "Clicked on: ${currentMovie.title}", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the total number of items
    override fun getItemCount(): Int {
        return movieList.size
    }
}
