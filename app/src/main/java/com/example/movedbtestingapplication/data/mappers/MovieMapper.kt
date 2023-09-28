package com.example.movedbtestingapplication.data.mappers

import com.example.movedbtestingapplication.data.model.Result
import com.example.movedbtestingapplication.domain.model.MovieData

fun Result.toDomain():MovieData{
    return MovieData(
        title = title,
        bgImg = poster_path,
        description = overview
    )
}