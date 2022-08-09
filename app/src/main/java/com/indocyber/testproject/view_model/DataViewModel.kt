package com.indocyber.testproject.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.indocyber.api_service.usecase.DataUseCase
import com.indocyber.common.AppResponse
import com.indocyber.common.BaseViewModel
import com.indocyber.common.entity.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    application: Application, val dataUseCase: DataUseCase
) : BaseViewModel(application) {
    val data = MutableLiveData<AppResponse<Response>>()

    fun getDataList() {
        viewModelScope.launch {
            dataUseCase().collect {
                data.postValue(it)
            }
        }
    }
}