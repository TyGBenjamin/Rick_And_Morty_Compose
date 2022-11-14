package com.example.rickandmortycompose.model.mapper

import com.example.rickandmortycompose.model.dto.LocationDTO
import com.example.rickandmortycompose.model.dto.LocationDetailsDTO
import com.example.rickandmortycompose.model.entity.Location
import com.example.rickandmortycompose.model.entity.LocationDetails

/**
 * Location mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class LocationDetailsMapper : Mapper<LocationDetailsDTO, LocationDetails> {
    override fun invoke(dto: LocationDetailsDTO): LocationDetails {
        return with(dto) {
            LocationDetails(
                name = name ?: "",
                url = url ?: "",
                dimension = dimension,
                type = type,
                id = id,
                residents = residents
            )
        }
    }
}
