package com.example.movedbtestingapplication.data.repository

import com.example.movedbtestingapplication.ApiException
import com.example.movedbtestingapplication.data.mappers.toDomain
import com.example.movedbtestingapplication.data.service.MovieService
import com.example.movedbtestingapplication.domain.model.MovieData
import com.example.movedbtestingapplication.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val service: MovieService):MovieRepository {
    override suspend fun getMovies(): List<MovieData> {
        val response = service.getMovies()
         if (response.isSuccessful) {
            val body = response.body()?.results ?: emptyList()
             return body.map { it.toDomain() }
        } else {
            throw ApiException("Error al obtener datos de la API")
        }
    }

}
