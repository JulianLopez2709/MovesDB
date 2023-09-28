package com.example.movedbtestingapplication.domain.repository

import com.example.movedbtestingapplication.data.model.Result
import com.example.movedbtestingapplication.data.model.movieResponse
import com.example.movedbtestingapplication.domain.model.MovieData

interface MovieRepository {
    suspend fun getMovies(): List<MovieData>
}