package com.malpvaplicaciones.code_retrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class Brawler(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("link")
    val extraInfo: String,

    @SerializedName("imageUrl")
    val image: String,

    @SerializedName("class")
    val type: Type,

    @SerializedName("rarity")
    val rarity: Rarity
)