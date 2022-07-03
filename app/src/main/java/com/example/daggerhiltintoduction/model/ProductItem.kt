package com.example.daggerhiltintoduction.model

import android.os.Parcelable
import com.example.daggerhiltintoduction.model.Rating
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
) : Parcelable
