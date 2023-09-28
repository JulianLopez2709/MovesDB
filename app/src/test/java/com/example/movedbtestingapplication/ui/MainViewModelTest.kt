package com.example.movedbtestingapplication.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movedbtestingapplication.domain.model.MovieData
import com.example.movedbtestingapplication.domain.usecase.GetMovieUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @RelaxedMockK
    private lateinit var userCase: GetMovieUseCase

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MainViewModel(userCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test movie view model`() = runTest {
        val movieList = listOf(
            MovieData(
                title = "Película de prueba",
                bgImg = "asdfasdf",
                description = "cualquier cosa"
            ),
            MovieData(
                title = "Película de prueba",
                bgImg = "asdfasdf",
                description = "cualquier cosa"
            )
        )

        coEvery { userCase() } returns movieList

        // When
        viewModel.getMovies()

        println("viewModel.listMovie.value: ${viewModel.listMovie.value}")
        println("movieList: $movieList")


        // Then
        assert(userCase() == movieList)
    }
}