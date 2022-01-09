package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.AddressDto
import com.kishorebabu.posts.data.network.model.GeoDto
import com.kishorebabu.posts.domain.model.Address
import com.kishorebabu.posts.domain.model.Geo
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