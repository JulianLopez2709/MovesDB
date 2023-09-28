package com.example.movedbtestingapplication.domain.usecase

import com.example.movedbtestingapplication.data.model.Result
import com.example.movedbtestingapplication.domain.model.MovieData
import com.example.movedbtestingapplication.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() : List<MovieData> {
        return movieRepository.getMovies()
    }
}