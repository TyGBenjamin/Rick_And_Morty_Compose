package com.example.rickandmortycompose.model.entity

@kotlinx.serialization.Serializable
data class Location(
    val name: String,
    val url: String?
)
