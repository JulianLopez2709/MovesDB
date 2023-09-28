package com.example.movedbtestingapplication.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movedbtestingapplication.databinding.ItemMovieBinding
import com.example.movedbtestingapplication.domain.model.MovieData

class MovieViewHolder(private val binding:ItemMovieBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieData) {
        binding.tvTittle.text = item.title
        Glide
            .with(binding.root)
            .load("https://image.tmdb.org/t/p/w185/${item.bgImg}")
            .into(binding.ivPhoto)
    }
}