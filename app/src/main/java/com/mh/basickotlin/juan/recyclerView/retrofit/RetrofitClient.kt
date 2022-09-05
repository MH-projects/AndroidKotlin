package com.mh.basickotlin.juan.recyclerView.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private const val connectionTimeOut = 10L
    private const val readTimeOut = 10L
    private const val writeTimeOut = 20L

    fun api(): ApiService {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(interceptor)
            /*
            * configuracion necesaria para retrofit
            * .base url
            * .client
            * */
            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            /*okHttpClient.connectTimeout(connectionTimeOut,TimeUnit.SECONDS)
            okHttpClient.readTimeout(connectionTimeOut,TimeUnit.SECONDS)
            okHttpClient.writeTimeout(connectionTimeOut,TimeUnit.SECONDS)*/
        }
        return retrofit
            .build()
            .create(ApiService::class.java)
    }
}
