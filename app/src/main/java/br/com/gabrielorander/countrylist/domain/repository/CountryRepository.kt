package br.com.gabrielorander.countrylist.domain.repository

import br.com.gabrielorander.countrylist.data.model.DetailedCountry
import br.com.gabrielorander.countrylist.data.model.SimpleCountry

interface CountryRepository {
    suspend fun countryList(): List<SimpleCountry>

    suspend fun countryDetail(countryCode: String): DetailedCountry
}