package com.example.movedbtestingapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movedbtestingapplication.R
import com.example.movedbtestingapplication.databinding.ActivityMainBinding
import com.example.movedbtestingapplication.domain.model.MovieData
import com.example.movedbtestingapplication.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var adapter:MovieAdapter
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()

        mainViewModel.listMovie.observe(this, Observer {
            adapter.updateList(it)
        })

        mainViewModel.error.observe(this, Observer {
            println(it)
        })

        mainViewModel.getMovies()

    }

    private fun initAdapter() {
        adapter = MovieAdapter(emptyList())
        binding.rvMovie.layoutManager = GridLayoutManager(this, 2)
        binding.rvMovie.adapter = adapter
    }
}