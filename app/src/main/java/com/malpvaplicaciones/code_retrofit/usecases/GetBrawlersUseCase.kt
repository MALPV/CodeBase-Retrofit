package com.malpvaplicaciones.code_retrofit.usecases

import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.util.Result
import com.malpvaplicaciones.code_retrofit.repository.BrawlersRepository

class GetBrawlersUseCase(
    private val repository: BrawlersRepository = BrawlersRepository()
) {

    suspend fun invoke(): Result<MutableList<Brawler>> =
        repository.getBrawlers()
}