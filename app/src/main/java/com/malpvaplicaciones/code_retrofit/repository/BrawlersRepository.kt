package com.malpvaplicaciones.code_retrofit.repository

import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.data.network.model.Result
import com.malpvaplicaciones.code_retrofit.data.db.DbDummy
import com.malpvaplicaciones.code_retrofit.data.network.ApiService
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class BrawlersRepository(
    private val apiService:ApiService = ApiService()
) {
    suspend fun getBrawlers(): Result<MutableList<Brawler>> {
        var brawlersLocal = DbDummy.getLocalBrawlers()
        return if (brawlersLocal.size == 0) {
            try {
                brawlersLocal = apiService.getBrawlersRemote()
                DbDummy.saveBrawlersInDb(brawlersLocal)
                Result.Success(brawlersLocal)
            } catch (e: UnknownHostException) {
                Result.Error(Exception("Sin conexión a internet, verifique e intente nuevamente."))
            } catch (e: SocketTimeoutException) {
                Result.Error(Exception("Verifique la conexión a internet e intente nuevamente."))
            } catch (e: IOException) {
                Result.Error(Exception("Error inesperado, contacte al administrador."))
            }
        } else
            Result.Success(brawlersLocal)
    }
}