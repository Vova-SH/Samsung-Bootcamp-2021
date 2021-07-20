package com.clean.arch.mvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clean.arch.mvvm.data.entities.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY movies.id ASC")
    fun getAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM movies WHERE id = :movieId LIMIT 1")
    fun getMovieById(movieId: Long) : Movie?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movie: Movie)
}