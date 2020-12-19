package com.hungpham.database.entity

import androidx.room.Entity

@Entity
data class UserEntity(val userName: String, val password: String)