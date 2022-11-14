package com.example.rickandmortycompose.model.dto

import com.example.rickandmortycompose.model.entity.RickChar

data class EpisodeDTO(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
