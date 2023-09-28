package com.example.movedbtestingapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movedbtestingapplication.data.model.Result
import com.example.movedbtestingapplication.domain.model.MovieData
import com.example.movedbtestingapplication.domain.usecase.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

    private var _listMovie = MutableLiveData<List<MovieData>>()
    val listMovie = _listMovie
    private var _error = MutableLiveData<String>()
    val error = _error

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (getMovieUseCase().isNotEmpty()){
                    println(getMovieUseCase())
                    val listmovie = getMovieUseCase()
                    _listMovie.postValue(listmovie)
                }else{
                    _error.postValue("Error in conecction API")
                }
            }catch (e:IOException){
                _error.postValue("Error de red: ${e}")
            }
        }
        println("list Movies ${_listMovie.value}")

    }
}