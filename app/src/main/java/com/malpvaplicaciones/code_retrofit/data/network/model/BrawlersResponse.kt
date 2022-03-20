package com.malpvaplicaciones.code_retrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class BrawlersResponse(

    @SerializedName("items")
    val brawlers: MutableList<Brawler>
)
