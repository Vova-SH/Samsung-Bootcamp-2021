package com.clean.arch.mvvm.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.clean.arch.mvvm.data.dao.MovieDao
import com.clean.arch.mvvm.data.entities.Actor
import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.net.MovieApi

class MovieRepository(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao
) {

    val moviePopularFlow
        get() = Pager(
            pagingSourceFactory = { MovieDataSource(movieApi) },
            config = PagingConfig(
                pageSize = 20
            )
        ).flow
}