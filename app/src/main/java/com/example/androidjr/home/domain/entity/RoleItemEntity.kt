package com.example.androidjr.home.domain.entity

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class RoleItemEntity(
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
    val location: String,
    val company: String,
    val payment: BigDecimal
)