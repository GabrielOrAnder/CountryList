package br.com.gabrielorander.countrylist.data.repository

import br.com.gabrielorander.countrylist.data.model.DetailedCountry
import br.com.gabrielorander.countrylist.data.model.SimpleCountry
import br.com.gabrielorander.countrylist.domain.repository.CountryRepository

class ApolloClient(
    private val apolloClient: ApolloClient
): CountryRepository {
    override suspend fun countryList(): List<SimpleCountry> {
        TODO("Not yet implemented")
    }

    override suspend fun countryDetail(countryCode: String): DetailedCountry {
        TODO("Not yet implemented")
    }
}