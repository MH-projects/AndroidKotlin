package com.mh.mhapp.data.network

import com.google.gson.GsonBuilder
import com.mh.basickotlin.manuel.recycler.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    fun api(): ApiService {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(interceptor)

            okhttpClient.connectTimeout(20L, TimeUnit.SECONDS)
            okhttpClient.readTimeout(20L, TimeUnit.SECONDS)
            okhttpClient.writeTimeout(20L, TimeUnit.SECONDS)

            // Configuración necesaria para Retrofit
            // .baseURL
            // .client(OkHttpClient.Builder())

            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }

        return retrofit
            .build()
            .create(ApiService::class.java)
    }
}
