package com.malpvaplicaciones.code_retrofit.data.db

import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler

object DbDummy {

    private var brawlersLocal = mutableListOf<Brawler>()

    fun saveBrawlersInDb(brawlers: MutableList<Brawler>){
        brawlersLocal = brawlers
    }

    fun getLocalBrawlers() = brawlersLocal
}