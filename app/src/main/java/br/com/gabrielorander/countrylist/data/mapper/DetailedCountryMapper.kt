package br.com.gabrielorander.countrylist.data.mapper

import br.com.gabrielorander.countrylist.CountryDetailQuery
import br.com.gabrielorander.countrylist.data.model.DetailedCountry

fun CountryDetailQuery.Country.toDetailedCountry(): DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}