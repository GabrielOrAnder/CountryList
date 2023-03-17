package br.com.gabrielorander.countrylist.data.repository

import br.com.gabrielorander.countrylist.CountryDetailQuery
import br.com.gabrielorander.countrylist.CountryListQuery
import br.com.gabrielorander.countrylist.data.mapper.toDetailedCountry
import br.com.gabrielorander.countrylist.data.mapper.toSimpleCountry
import br.com.gabrielorander.countrylist.data.model.DetailedCountry
import br.com.gabrielorander.countrylist.data.model.SimpleCountry
import br.com.gabrielorander.countrylist.domain.repository.CountryRepository
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryRepository {
    override suspend fun countryList(): List<SimpleCountry> {
        val response = try {
            apolloClient
                .query(CountryListQuery()).execute()
        } catch (e: ApolloException) {
            throw CountryRepositoryException("Failed to retrieve Countries", e)
        }

        if (response.hasErrors()) {
            throw CountryRepositoryException("Failed to retrieve country list: ${response.errors}")
        }

        return response.data?.countries?.map { it.toSimpleCountry() } ?: emptyList()
    }

    override suspend fun countryDetail(countryCode: String): DetailedCountry? {
        val response = try {
            apolloClient
                .query(CountryDetailQuery(countryCode)).execute()
        } catch (e: ApolloException) {
            throw CountryRepositoryException(
                "Failed to get Country info, Country code: $countryCode",
                e
            )
        }

        if (response.hasErrors()) {
            throw CountryRepositoryException("Failed to retrieve country detail: ${response.errors}")
        }

        return response.data?.country?.toDetailedCountry()
    }
}