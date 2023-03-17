package br.com.gabrielorander.countrylist.domain.use_case

import br.com.gabrielorander.countrylist.data.model.SimpleCountry
import br.com.gabrielorander.countrylist.data.repository.ApolloCountryClient
import br.com.gabrielorander.countrylist.domain.repository.CountryRepository

class GetCountriesUseCase(
    private val repository: CountryRepository
) {
    suspend fun execute(): List<SimpleCountry> {
        return repository.countryList().sortedBy { it.name }
    }
}