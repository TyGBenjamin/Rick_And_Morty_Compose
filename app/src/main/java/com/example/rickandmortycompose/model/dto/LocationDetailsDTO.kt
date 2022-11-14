package com.example.rickandmortycompose.model.dto

data class LocationDetailsDTO(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)
