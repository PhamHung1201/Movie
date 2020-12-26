package com.hungpham.data.internal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey val token: String, val userName: String, val password: String)