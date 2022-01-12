package com.kishorebabu.posts.data.mapper

import com.kishorebabu.posts.TestHelper.randomString
import com.kishorebabu.posts.data.network.model.GeoDto
import com.kishorebabu.posts.domain.model.Geo
import org.junit.Assert.assertEquals
import org.junit.Test

class GeoDtoToEntityMapperTest {
    private val sut = GeoDtoToEntityMapper()

    @Test
    fun `map should return expected domain object when mapped from dto object`() {
        val fakeGeoDto = GeoDto(
            lat = fakeLat,
            lng = fakeLng
        )

        val fakeGeo = Geo(
            lat = fakeLat,
            lng = fakeLng
        )

        val result = sut.map(fakeGeoDto)
        assertEquals(fakeGeo, result)
    }

    private companion object {
        val fakeLat = randomString
        val fakeLng = randomString
    }


}