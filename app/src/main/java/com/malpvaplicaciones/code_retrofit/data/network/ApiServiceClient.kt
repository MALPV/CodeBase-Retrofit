package com.malpvaplicaciones.code_retrofit.data.network

import com.malpvaplicaciones.code_retrofit.data.network.ApiServiceBuilder.GET_BRAWLERS
import com.malpvaplicaciones.code_retrofit.data.network.model.BrawlerResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceClient {

    @GET(GET_BRAWLERS)
    suspend fun getBrawlers(): Response<BrawlerResponse>
}