package com.malpvaplicaciones.code_retrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class BrawlerResponse(

    @SerializedName("list")
    val brawlers: MutableList<Brawler>
)
