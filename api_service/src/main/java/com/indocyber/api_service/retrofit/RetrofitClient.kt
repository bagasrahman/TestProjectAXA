package com.indocyber.api_service.retrofit

import android.content.Context
import android.util.Log
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.GanderInterceptor
import com.ashokvarma.gander.imdb.GanderIMDB
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getClient(context: Context): Retrofit {
        Gander.setGanderStorage(GanderIMDB.getInstance())
        return Retrofit.Builder().client(
            OkHttpClient().newBuilder().addInterceptor(
                HttpLoggingInterceptor() {
                    Log.e("inetLog", it)
                }
            ).addInterceptor(
                GanderInterceptor(context).showNotification(true)
            ).build()
        ).baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            ).build()
    }
}