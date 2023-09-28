package com.example.movedbtestingapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movedbtestingapplication.databinding.ItemMovieBinding
import com.example.movedbtestingapplication.domain.model.MovieData

class MovieAdapter(private var listMovie:List<MovieData>):RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = listMovie[position]
        holder.bind(item)
    }

    fun updateList(newList:List<MovieData>){
        listMovie = newList
        notifyDataSetChanged()
    }
}