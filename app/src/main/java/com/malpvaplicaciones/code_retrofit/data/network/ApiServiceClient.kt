package com.malpvaplicaciones.code_retrofit.data.network

import com.malpvaplicaciones.code_retrofit.data.network.ApiServiceBuilder.AUTH_HEADER
import com.malpvaplicaciones.code_retrofit.data.network.ApiServiceBuilder.GET_BRAWLERS
import com.malpvaplicaciones.code_retrofit.data.network.model.BrawlersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServiceClient {

    @GET(GET_BRAWLERS)
    suspend fun getBrawlers(
        @Header("Authorization")
        authHeader: String = AUTH_HEADER
    ): Response<BrawlersResponse>
}