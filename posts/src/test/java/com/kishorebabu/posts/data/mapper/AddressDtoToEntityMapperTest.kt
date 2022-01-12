package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.TestHelper.randomString
import com.kishorebabu.posts.data.network.model.AddressDto
import com.kishorebabu.posts.data.network.model.GeoDto
import com.kishorebabu.posts.domain.model.Address
import com.kishorebabu.posts.domain.model.Geo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class AddressDtoToEntityMapperTest {
    private val mockGeoMapper = mock<Mapper<GeoDto, Geo>>()
    private val sut = AddressDtoToEntityMapper(mockGeoMapper)

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
        val fakeAddressDto = AddressDto(
            city = fakeCity,
            street = fakeStreet,
            suite = fakeSuite,
            zipcode = fakeZipcode,
            geo = fakeGeoDto
        )

        val fakeAddress = Address(
            city = fakeCity,
            street = fakeStreet,
            suite = fakeSuite,
            zipcode = fakeZipcode,
            geo = fakeGeo
        )


        whenever(mockGeoMapper.map(fakeGeoDto)).thenReturn(fakeGeo)

        val result = sut.map(fakeAddressDto)
        assertEquals(result, fakeAddress)
    }

    private companion object {
        val fakeLat = "23.45"
        val fakeLng = "45.32"
        val fakeCity = randomString
        val fakeStreet = randomString
        val fakeSuite = randomString
        val fakeZipcode = randomString
    }
}