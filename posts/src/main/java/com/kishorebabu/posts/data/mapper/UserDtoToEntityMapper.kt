package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.AddressDto
import com.kishorebabu.posts.data.network.model.CompanyDto
import com.kishorebabu.posts.data.network.model.UserDto
import com.kishorebabu.posts.domain.model.Address
import com.kishorebabu.posts.domain.model.Company
import com.kishorebabu.posts.domain.model.User
import javax.inject.Inject

internal class UserDtoToEntityMapper @Inject constructor(
    private val addressMapper: Mapper<AddressDto, Address>,
    private val companyMapper: Mapper<CompanyDto, Company>,
) : Mapper<UserDto, User> {
    override fun map(input: UserDto): User {
        return with(input) {
            User(
                id = id.toString(),
                address = addressMapper.map(address),
                company = companyMapper.map(company),
                email = email,
                name = name,
                phone = phone,
                username = username,
                website = website,
            )
        }
    }
}