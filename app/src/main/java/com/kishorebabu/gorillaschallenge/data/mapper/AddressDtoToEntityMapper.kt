package com.kishorebabu.gorillaschallenge.data.mapper

import com.kishorebabu.gorillaschallenge.utils.Mapper
import com.kishorebabu.gorillaschallenge.data.network.model.AddressDto
import com.kishorebabu.gorillaschallenge.data.network.model.GeoDto
import com.kishorebabu.gorillaschallenge.domain.model.Address
import com.kishorebabu.gorillaschallenge.domain.model.Geo
import javax.inject.Inject

internal class AddressDtoToEntityMapper @Inject constructor(
    private val geoMapper: Mapper<GeoDto, Geo>
) : Mapper<AddressDto, Address> {
    override fun map(input: AddressDto): Address {
        return with(input) {
            Address(
                city = city,
                street = street,
                suite = suite,
                zipcode = zipcode,
                geo = geoMapper.map(geo),
            )
        }
    }
}