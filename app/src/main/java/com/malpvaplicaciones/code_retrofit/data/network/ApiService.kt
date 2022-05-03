package com.malpvaplicaciones.code_retrofit.data.network

import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val apiServiceBuilder = ApiServiceBuilder.invoke()

    suspend fun getBrawlersRemote(): MutableList<Brawler>{
        return withContext(Dispatchers.IO) {
            val response = apiServiceBuilder.getBrawlers()
            response.body()?.brawlers ?: mutableListOf()
        }
    }
}