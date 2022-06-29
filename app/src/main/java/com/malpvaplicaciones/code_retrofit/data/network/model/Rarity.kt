package com.malpvaplicaciones.code_retrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class Rarity(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("color")
    val color: String
)
