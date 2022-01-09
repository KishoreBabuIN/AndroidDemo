package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.GeoDto
import com.kishorebabu.posts.domain.model.Geo
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