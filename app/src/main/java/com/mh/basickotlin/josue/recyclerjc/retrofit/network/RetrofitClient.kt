/*
 * RetrofitClient.kt
 * Android Kotlin App
 * Created by Josue Isaias on 05/09/2022, 12:57:45
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.retrofit.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun callApi(): ApiServices {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.addInterceptor(interceptor)

            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit
            .build()
            .create(ApiServices::class.java)
    }
}
