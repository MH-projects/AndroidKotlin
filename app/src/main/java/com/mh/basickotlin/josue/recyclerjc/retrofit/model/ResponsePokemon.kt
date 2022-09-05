/*
 * ResponsePokemon.kt
 * Android Kotlin App
 * Created by Josue Isaias on 05/09/2022, 12:58:53
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.retrofit.model

import com.google.gson.annotations.SerializedName

data class ResponsePokemon(
    @SerializedName("results")
    var listpokemon: List<PokemonName>
)

data class PokemonName(
    @SerializedName("name")
    var name: String
)
