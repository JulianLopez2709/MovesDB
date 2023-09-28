package com.example.movedbtestingapplication.data.service

import com.example.movedbtestingapplication.data.model.movieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movie/popular")
    suspend fun getMovies():Response<movieResponse>
}