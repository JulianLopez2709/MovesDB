package com.example.movedbtestingapplication.data.model

data class movieResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)