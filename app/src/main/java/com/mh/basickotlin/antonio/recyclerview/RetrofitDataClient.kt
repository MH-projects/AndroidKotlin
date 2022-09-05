package com.example.antonioapp.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataClient {
    private const val CONNECTION_TIMEOUT=10L
    private const val READ_TIMEOUT=30L
    private const val WRITE_TIMEOUT=30L
    //lazy no se cargara en memoria hasta que se use
    //lateinit var se declara y antes de usar se tiene que inicializar
    fun api():ApiService{
        val retrofit:Retrofit.Builder by lazy {
            val okHttpClient=OkHttpClient.Builder()
            val interceptro=HttpLoggingInterceptor()
            interceptro.setLevel(HttpLoggingInterceptor.Level.BODY)

            //okHttpClient.connectTimeout(CONNECTION_TIMEOUT,TimeUnit.SECONDS),
            Retrofit.Builder()
                .baseUrl("https:/pokeapi.co/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit.build().create(ApiService::class.java)
    }
}