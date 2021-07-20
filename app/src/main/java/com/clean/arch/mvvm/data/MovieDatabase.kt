package com.clean.arch.mvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clean.arch.mvvm.data.entities.Movie
import com.clean.arch.mvvm.data.dao.MovieDao

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}