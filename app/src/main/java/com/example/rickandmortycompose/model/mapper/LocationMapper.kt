package com.example.rickandmortycompose.model.mapper

import com.example.rickandmortycompose.model.dto.LocationDTO
import com.example.rickandmortycompose.model.entity.Location

/**
 * Location mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class LocationMapper : Mapper<LocationDTO,Location > {
    override fun invoke(dto: LocationDTO): Location {
        return with(dto) {
            Location(
                name = name ?: "",
                url = url ?: ""
            )
        }
    }
}
