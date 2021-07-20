package com.clean.arch.mvvm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clean.arch.mvvm.data.entities.Actor
import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.data.repositories.MovieRepository
import com.clean.arch.mvvm.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieViewModel(
    private val repository: MovieRepository,
    private val movie: Movie
) : ViewModel() {
    val stateMovie: LiveData<State<Movie>> = liveData {
        emit(State.Loading())
        withContext(Dispatchers.IO) {
            try {
                emit(State.Success(repository.getMovie(movie.id)))
            } catch (e: Exception) {
                emit(State.Error<Movie>(e))
            }
        }
    }

    val stateActors: LiveData<State<List<Actor>>> = liveData {
        emit(State.Loading())
        withContext(Dispatchers.IO) {
            try {
                emit(State.Success(repository.getMovieCredits(movie.id)))
            } catch (e: Exception) {
                emit(State.Error<List<Actor>>(e))
            }
        }
    }
}