package com.example.rickandmortycompose.model.mapper

import android.location.Location
import com.example.rickandmortycompose.model.dto.LocationDTO
import com.example.rickandmortycompose.model.dto.OriginDTO
import com.example.rickandmortycompose.model.dto.RickCharDTO
import com.example.rickandmortycompose.model.entity.RickChar

/**
 * Card mapper to convert [CardDTO] to [Card] entity.
 *
 * @constructor Create empty Student mapper.
 */

class RickCharMapper(private val originMapper: OriginMapper, private val locationMapper: LocationMapper, private val episodeMapper: EpisodeMapper) :
    Mapper<RickCharDTO, RickChar> {
    override fun invoke(dto: RickCharDTO): RickChar {
        return with(dto) {
            RickChar(
                created = created,
            episode = episode,
            gender = gender,
            id = id,
            image = image,
            location = locationMapper.invoke(dto.location),
            name = name,
            origin = originMapper.invoke(dto.origin),
            species = species,
            status = status,
            type = type,
            url = url
            )
        }
    }
}
