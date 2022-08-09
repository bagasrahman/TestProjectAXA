package com.indocyber.testproject.module

import android.content.Context
import com.indocyber.api_service.retrofit.RetrofitClient
import com.indocyber.api_service.service.DataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(@ApplicationContext context: Context) =
        RetrofitClient.getClient(context)

    @Provides
    @Singleton
    fun provideDataService(retrofit: Retrofit) =retrofit.create(DataService::class.java)
}