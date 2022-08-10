package com.indocyber.testproject.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.indocyber.api_service.usecase.DataUseCase
import com.indocyber.common.AppResponse
import com.indocyber.common.BaseViewModel
import com.indocyber.common.ResponseSuccess
import com.indocyber.common.entity.Response
import com.indocyber.common.entity.ResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    application: Application, val dataUseCase: DataUseCase
) : BaseViewModel(application) {
    val data = MutableLiveData<AppResponse<List<ResponseItem>>>()
    val searchText = MutableLiveData<String>()

    init {
        Log.i("data", "GET DATA")
        getDataList()
    }

    fun getDataList() {
        viewModelScope.launch {
            dataUseCase.invoke(q = searchText.value).collect {
                data.postValue(it)
            }
        }
    }

    fun filter(q: String): List<ResponseItem> = data.value?.let {
        if (it is ResponseSuccess) {
            it.data.orEmpty().filter {
                it.title.contains(q, true)
            }
        } else { arrayListOf() }
    } ?: run { arrayListOf() }


}