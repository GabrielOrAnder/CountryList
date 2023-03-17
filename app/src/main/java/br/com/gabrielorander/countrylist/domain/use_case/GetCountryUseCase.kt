package br.com.gabrielorander.countrylist.domain.use_case

import br.com.gabrielorander.countrylist.data.model.DetailedCountry
import br.com.gabrielorander.countrylist.data.model.SimpleCountry
import br.com.gabrielorander.countrylist.data.repository.ApolloCountryClient
import br.com.gabrielorander.countrylist.domain.repository.CountryRepository

class GetCountryUseCase(
    private val repository: CountryRepository
) {
    suspend fun execute(countryCode: String): DetailedCountry? {
        return repository.countryDetail(countryCode)
    }
}