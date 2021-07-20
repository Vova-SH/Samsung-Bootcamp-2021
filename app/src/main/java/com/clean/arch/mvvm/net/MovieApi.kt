package com.clean.arch.mvvm.net

import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.data.entities.MovieCredits
import com.clean.arch.mvvm.data.entities.MoviesPage
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMoviesPage(
        @Query("page") pageNum : Int
    ) : MoviesPage

    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") id : Long
    ) : Movie

    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(
        @Path("id") id : Long
    ) : MovieCredits
}