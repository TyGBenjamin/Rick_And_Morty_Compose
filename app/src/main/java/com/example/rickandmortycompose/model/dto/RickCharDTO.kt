package com.example.rickandmortycompose.model.dto

import com.example.rickandmortycompose.model.entity.Episode

data class RickCharDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDTO,
    val name: String,
    val origin: OriginDTO,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
