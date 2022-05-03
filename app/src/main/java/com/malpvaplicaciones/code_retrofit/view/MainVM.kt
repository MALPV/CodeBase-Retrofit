package com.malpvaplicaciones.code_retrofit.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malpvaplicaciones.code_retrofit.data.network.model.Brawler
import com.malpvaplicaciones.code_retrofit.data.network.model.Result
import com.malpvaplicaciones.code_retrofit.usecases.GetBrawlersUseCase
import kotlinx.coroutines.launch

class MainVM(
    private val getBrawlersUseCase: GetBrawlersUseCase = GetBrawlersUseCase()
): ViewModel() {

    private val _brawlersList = MutableLiveData<MutableList<Brawler>>()
    val brawlersList: LiveData<MutableList<Brawler>> get() = _brawlersList

    private val _messageError = MutableLiveData<String>()
    val messageError: LiveData<String> get() = _messageError

    fun getBrawlers(){
       viewModelScope.launch {
           when(val result = getBrawlersUseCase.invoke()) {
               is Result.Success<MutableList<Brawler>> ->{
                   _brawlersList.value = result.data ?: mutableListOf()
               }
               is Result.Error -> {
                   _messageError.value = result.exception.message
               }
           }
       }
    }

}