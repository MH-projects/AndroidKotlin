package com.mh.basickotlin.manuel.recycler.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v2/pokemon?")
    suspend fun getPokemon(@Query("limit") limit: Int): ResponsePokemon
}
