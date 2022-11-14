package com.example.rickandmortycompose.model.mapper

import com.example.rickandmortycompose.model.dto.OriginDTO
import com.example.rickandmortycompose.model.entity.Origin

/**
 * Origin mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class OriginMapper : Mapper<OriginDTO, Origin> {
    override fun invoke(dto: OriginDTO): Origin {
        return with(dto) {
            Origin(
                name = name ?: "",
                url = url ?: ""
            )
        }
    }
}
