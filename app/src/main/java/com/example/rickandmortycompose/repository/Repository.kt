package com.example.rickandmortycompose.repository

import com.example.rickandmortycompose.model.entity.Episode
import com.example.rickandmortycompose.model.entity.LocationDetails
import com.example.rickandmortycompose.model.entity.RickChar
import com.example.rickandmortycompose.util.Resource

interface Repository {
    suspend fun getCharacters() : Resource<List<RickChar>>
    suspend fun getCharacterByIdAPI(id:Int) : Resource<RickChar>
    suspend fun getEpisodeById(id:Int) : Resource<Episode>
    suspend fun getLocationById(id:Int) : Resource<LocationDetails>
}
