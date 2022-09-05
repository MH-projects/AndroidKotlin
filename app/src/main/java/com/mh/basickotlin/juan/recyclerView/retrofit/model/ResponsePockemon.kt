package com.example.profile.data.model

import com.google.gson.annotations.SerializedName
data class Species(
    @SerializedName("name")
    var name: String

)
data class version(
    @SerializedName("name")
    var name: String
)
data class forms(
    @SerializedName("name")
    var name: String
)
data class move_learn_method(
    @SerializedName("name")
    var name: String
)
data class version_group_details(
    @SerializedName("move_learn_method")
    var learn: move_learn_method
)
data class GameIndex(
    @SerializedName("version")
    var version: version
)
data class Moves(
    @SerializedName("version_group_details")
    var version: List<version_group_details>
)
data class result(
    @SerializedName("name")
    var name: String,

    @SerializedName("url")
    var url: String
)
data class ResponsePockemon(
    // { Tipo de dato Objeto }
    // [lista de objetos o datos simples]
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("weight")
    var weight: Int,

    @SerializedName("species")
    var species: Species,

    @SerializedName("forms")
    var forms: List<forms>,

    @SerializedName("game_indices")
    var game: List<GameIndex>,

    @SerializedName("moves")
    var moves: List<Moves>,

    @SerializedName("results")
    var results: List<result>
)
// name
// game_indices->version->name
// moves->move->version_group_details->move_learn_method->name
