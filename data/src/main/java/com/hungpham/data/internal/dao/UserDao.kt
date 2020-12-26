package com.hungpham.data.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import com.hungpham.data.internal.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userEntity: UserEntity)
}