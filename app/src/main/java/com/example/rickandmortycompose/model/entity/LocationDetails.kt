package com.example.rickandmortycompose.model.entity

data class LocationDetails(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)
