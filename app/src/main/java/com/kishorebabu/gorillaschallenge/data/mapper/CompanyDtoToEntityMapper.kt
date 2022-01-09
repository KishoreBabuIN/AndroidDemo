package com.kishorebabu.gorillaschallenge.data.mapper

import com.kishorebabu.gorillaschallenge.utils.Mapper
import com.kishorebabu.gorillaschallenge.data.network.model.CompanyDto
import com.kishorebabu.gorillaschallenge.domain.model.Company
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