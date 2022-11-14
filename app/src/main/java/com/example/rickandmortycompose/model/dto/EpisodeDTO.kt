package com.example.rickandmortycompose.model.dto

import com.example.rickandmortycompose.model.entity.RickChar
import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class EpisodeDTO(
    @SerializedName("air_date")
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
