package com.kishorebabu.posts.data.mapper

import com.kishorebabu.posts.TestHelper.randomString
import com.kishorebabu.posts.data.network.model.CompanyDto
import com.kishorebabu.posts.domain.model.Company
import org.junit.Assert.assertEquals
import org.junit.Test

class CompanyDtoToEntityMapperTest {
    private val sut = CompanyDtoToEntityMapper()

    @Test
    fun `map should return expected domain object when mapped from dto object`() {
        val fakeCompanyDto = CompanyDto(
            bs = randomString,
            catchPhrase = randomString,
            name = randomString
        )

        val fakeCompany = Company(
            bs = randomString,
            catchPhrase = randomString,
            name = randomString
        )

        val result = sut.map(fakeCompanyDto)
        assertEquals(fakeCompany, result)
    }
}