/*
 * PokemonResponse.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 05/09/2022, 12:56:52
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.retrofit

import com.google.gson.annotations.SerializedName

data class PokemonName(
    @SerializedName("name")
    var name: String
)

data class ResponsePokemon(

    @SerializedName("results")
    var listPokemon: List<PokemonName>
)
