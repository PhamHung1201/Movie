package com.hungpham.data.internal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hungpham.data.internal.dao.GenreDao
import com.hungpham.data.internal.dao.UserDao
import com.hungpham.data.internal.entity.GenreEntity
import com.hungpham.data.internal.entity.UserEntity


@Database(entities = [UserEntity::class, GenreEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "com.hungpham.movie.db"

        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }

    abstract fun userDao(): UserDao

    abstract fun genreDao(): GenreDao
}