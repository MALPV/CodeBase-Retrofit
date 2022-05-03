package com.malpvaplicaciones.code_retrofit.usecases

import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.data.network.model.BrawlersResponse
import com.malpvaplicaciones.code_retrofit.data.network.model.Result
import com.malpvaplicaciones.code_retrofit.repository.BrawlersRepository
import retrofit2.Response

class GetBrawlersUseCase(
    private val repository: BrawlersRepository = BrawlersRepository()
) {

    suspend fun invoke(): Result<MutableList<Brawler>> =
        repository.getBrawlers()
}