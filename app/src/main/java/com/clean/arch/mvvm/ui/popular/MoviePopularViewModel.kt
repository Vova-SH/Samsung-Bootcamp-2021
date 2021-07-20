package com.clean.arch.mvvm.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.clean.arch.mvvm.data.repositories.MovieRepository

class MoviePopularViewModel(private val repository: MovieRepository) : ViewModel() {
    val moviePage = repository.moviePopularFlow
            .cachedIn(viewModelScope).asLiveData()
}