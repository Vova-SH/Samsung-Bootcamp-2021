package com.clean.arch.mvvm.data.entities

import com.google.gson.annotations.SerializedName

data class Actor(
    val name : String,
    val character : String,
    @SerializedName("profile_path")
    val imageUrl : String?
)
