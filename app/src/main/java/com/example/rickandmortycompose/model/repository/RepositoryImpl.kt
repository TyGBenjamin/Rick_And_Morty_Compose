package com.example.rickandmortycompose.model.repository

import com.example.rickandmortycompose.model.dto.RickCharDTO
import com.example.rickandmortycompose.model.entity.Episode
import com.example.rickandmortycompose.model.entity.LocationDetails
import com.example.rickandmortycompose.model.entity.RickChar
import com.example.rickandmortycompose.model.mapper.EpisodeMapper
import com.example.rickandmortycompose.model.mapper.LocationDetailsMapper
import com.example.rickandmortycompose.model.mapper.LocationMapper
import com.example.rickandmortycompose.model.mapper.OriginMapper
import com.example.rickandmortycompose.model.mapper.RickCharMapper
import com.example.rickandmortycompose.model.retrofit.RetrofitClass
import com.example.rickandmortycompose.repository.Repository
import com.example.rickandmortycompose.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImpl : Repository {
    private val apiInstance by lazy { RetrofitClass.getApiService() }
    private val episodeMapper: EpisodeMapper = EpisodeMapper()
    private val originMapper: OriginMapper = OriginMapper()
    private val locationMapper: LocationMapper = LocationMapper()
    private val locationDetailsMapper: LocationDetailsMapper = LocationDetailsMapper()
    private val mapper: RickCharMapper = RickCharMapper(
        originMapper = originMapper, locationMapper = locationMapper, episodeMapper = episodeMapper
    )

    override suspend fun getCharacters(): Resource<List<RickChar>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getCharacters()
            if (res.isSuccessful && res.body() != null) {
                println(res.body())
                Resource.Success(res.body()!!.results.map { mapper(it) })
            } else {
                Resource.Error(res.message())
            }

        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getCharacterByIdAPI(id: Int): Resource<RickChar> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getCharacterById(id)
                if (res.isSuccessful && res.body() != null) {
                    val response = res.body()
                    val char = mapChar(response!!)
                    Resource.Success(char)
                } else {
                    Resource.Error("Someting Wrong")
                }
            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }

    fun mapChar(dto: RickCharDTO): RickChar {
        return mapper(dto)
    }

    override suspend fun getEpisodeById(id: Int): Resource<Episode> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getEpisodeById(id)
            if (res.isSuccessful && res.body() != null) {
                val result = episodeMapper(res.body()!!)

                Resource.Success(result)
            } else {
                Resource.Error("Someting Wrong")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getLocationById(id: Int): Resource<LocationDetails> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getLocationById(id)
                if (res.isSuccessful && res.body() != null) {
                    val result = locationDetailsMapper(res.body()!!)
                    Resource.Success(result)
                } else {
                    Resource.Error("Someting Wrong")
                }
            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }
}

