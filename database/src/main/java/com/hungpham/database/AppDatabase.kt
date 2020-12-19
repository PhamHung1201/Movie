package com.hungpham.database

import androidx.room.Database
import com.hungpham.database.dao.UserDao
import com.hungpham.database.entity.UserEntity


@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase {

    abstract fun uerDao(): UserDao
}