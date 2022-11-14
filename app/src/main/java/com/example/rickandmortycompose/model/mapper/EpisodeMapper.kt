package com.example.rickandmortycompose.model.mapper

import com.example.rickandmortycompose.model.dto.EpisodeDTO
import com.example.rickandmortycompose.model.dto.LocationDTO
import com.example.rickandmortycompose.model.entity.Episode
import com.example.rickandmortycompose.model.entity.Location
import com.example.rickandmortycompose.model.entity.Origin

/**
 * Episode mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class EpisodeMapper : Mapper<EpisodeDTO, Episode> {
    override fun invoke(dto: EpisodeDTO): Episode {
        return with(dto) {
            Episode(
                air_date = air_date,
            characters = characters,
            created = created,
            episode = episode,
            id = id,
            name = name,
            url = url
            )
        }
    }
}
