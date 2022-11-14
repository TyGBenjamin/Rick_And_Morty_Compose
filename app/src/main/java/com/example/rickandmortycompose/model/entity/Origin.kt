package com.example.rickandmortycompose.model.entity

@kotlinx.serialization.Serializable
data class Origin(
val name: String,
val url: String?
){
    override fun toString(): String {
        return "$name:$url"
    }
}
