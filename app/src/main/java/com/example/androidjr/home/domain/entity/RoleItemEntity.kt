package com.example.androidjr.home.domain.entity

import androidx.annotation.DrawableRes

data class RoleItemEntity(
    val title: String,
    @DrawableRes val image: Int
)