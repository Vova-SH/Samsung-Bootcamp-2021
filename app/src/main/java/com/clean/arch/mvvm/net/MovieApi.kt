package com.clean.arch.mvvm.net

import com.clean.arch.mvvm.data.entities.MoviesPage
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMoviesPage(
        @Query("page") pageNum : Int
    ) : MoviesPage
}