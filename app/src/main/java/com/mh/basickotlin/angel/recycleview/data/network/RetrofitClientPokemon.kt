package com.example.aplicationangel.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientPokemon {

    private const val connectionTimeOut = 10L
    private const val readTiemOut = 30L
    private const val writeTimeOut = 30L

    fun api(): ApiService {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.addInterceptor(interceptor)

            Retrofit.Builder().baseUrl("https://pokeapi.co/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit.build().create(ApiService::class.java)
    }
}
