package com.example.rickandmortycompose.model.entity

import com.example.rickandmortycompose.model.dto.LocationDTO
import com.example.rickandmortycompose.model.dto.OriginDTO
import kotlinx.serialization.Contextual

@kotlinx.serialization.Serializable
data class RickChar (
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
