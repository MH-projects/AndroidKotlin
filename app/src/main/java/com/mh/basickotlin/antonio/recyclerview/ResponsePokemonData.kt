/*
 * ResponsePokemonData.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 05/09/2022, 12:57:13
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.recyclerview

import com.google.gson.annotations.SerializedName

data class PokemonName(
    @SerializedName("name")
    var name:String
)

data class ResponsePokemonData(
    @SerializedName("results")
    var listPokemon:List<PokemonName>
)
