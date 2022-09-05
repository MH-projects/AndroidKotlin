package com.example.aplicationangel.data.model

import com.google.gson.annotations.SerializedName

data class PokemonName(
    @SerializedName("name")
    var name: String
)

data class Response(
// Lo que viene entre llaves tipo de dato
// entre corchetes lista de datos o objetos simples

    @SerializedName("results")
    var listPokemon: List<PokemonName>
)

// game_indices->version->name
// moves->version_group_details->move_learn_method->name
