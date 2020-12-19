package com.hungpham.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.hungpham.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(userEntity: UserEntity)
}