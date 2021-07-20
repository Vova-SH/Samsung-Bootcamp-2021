package com.clean.arch.mvvm.di

import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.data.repositories.MovieRepository
import com.clean.arch.mvvm.ui.movie.MovieViewModel
import com.clean.arch.mvvm.ui.popular.MoviePopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single { MovieRepository(get(), get()) }

    viewModel { MoviePopularViewModel(get()) }
    viewModel { (movie: Movie) -> MovieViewModel(get(), movie) }
}