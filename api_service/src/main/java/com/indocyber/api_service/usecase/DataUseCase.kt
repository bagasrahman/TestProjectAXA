package com.indocyber.api_service.usecase

import com.indocyber.api_service.service.DataService
import com.indocyber.common.AppResponse
import com.indocyber.common.entity.Response
import com.indocyber.common.entity.ResponseItem
import kotlinx.coroutines.flow.flow

class DataUseCase(val dataService: DataService) {
    operator fun invoke(q: String?) = flow<AppResponse<List<ResponseItem>>> {
        emit(AppResponse.loading())
        try {
            val data = dataService.getData()
            if (data.isSuccessful) {
                data.body()?.let {
                    emit(AppResponse.success(it))
                } ?: run {
                    emit(AppResponse.errorBackend(data.code(), data.errorBody()))
                }
            } else {
                emit(AppResponse.errorBackend(data.code(), data.errorBody()))
            }
        } catch (e:Exception) {
            emit(AppResponse.errorSystem(e))
        }
    }
}