/*
 * ApiServices.kt
 * Android Kotlin App
 * Created by Josue Isaias on 05/09/2022, 12:56:25
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.retrofit.network

import com.mh.basickotlin.josue.recyclerjc.retrofit.model.ResponsePokemon
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/api/v2/pokemon?")
    suspend fun getPokemon(@Query("limit") limit: Int): ResponsePokemon
}