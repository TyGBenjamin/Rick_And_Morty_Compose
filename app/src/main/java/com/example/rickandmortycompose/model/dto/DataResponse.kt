package com.example.rickandmortycompose.model.dto

data class DataResponse(
    val info: InfoDTO,
    val results: List<RickCharDTO>
)
