package com.kishorebabu.gorillaschallenge.data.mapper

import com.kishorebabu.gorillaschallenge.core.Mapper
import com.kishorebabu.gorillaschallenge.data.network.model.GeoDto
import com.kishorebabu.gorillaschallenge.domain.model.Geo
import javax.inject.Inject

internal class GeoDtoToEntityMapper @Inject constructor() : Mapper<GeoDto, Geo> {
    override fun map(input: GeoDto): Geo {
        return with(input) {
            Geo(
                lat = lat,
                lng = lng,
            )
        }
    }
}