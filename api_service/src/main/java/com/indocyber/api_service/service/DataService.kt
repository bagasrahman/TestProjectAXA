package com.indocyber.api_service.service

import com.indocyber.common.entity.Response
import retrofit2.http.GET

interface DataService {
    @GET("photos")
    suspend fun getData(): retrofit2.Response<Response>
}