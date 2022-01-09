package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.CompanyDto
import com.kishorebabu.posts.domain.model.Company
import javax.inject.Inject

internal class CompanyDtoToEntityMapper @Inject constructor() : Mapper<CompanyDto, Company> {
    override fun map(input: CompanyDto): Company {
        return with(input) {
            Company(
                bs = bs,
                catchPhrase = catchPhrase,
                name = name,
            )
        }
    }
}