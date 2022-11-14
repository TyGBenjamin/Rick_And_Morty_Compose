package com.example.rickandmortycompose.model.remote

import com.example.rickandmortycompose.model.dto.DataResponse
import com.example.rickandmortycompose.model.dto.EpisodeDTO
import com.example.rickandmortycompose.model.dto.LocationDetailsDTO
import com.example.rickandmortycompose.model.dto.RickCharDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<DataResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<RickCharDTO>

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Response<EpisodeDTO>

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Response<LocationDetailsDTO>
}
