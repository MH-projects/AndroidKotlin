package com.example.antonioapp.data.network

import com.mh.basickotlin.antonio.recyclerview.ResponsePokemonData
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //api
    ///api/v2/pokemon/charizard?
    //limit =1
    @GET("api/v2/pokemon?")
    suspend fun getpokemon(@Query("limit") limit:Int
    ): ResponsePokemonData

}