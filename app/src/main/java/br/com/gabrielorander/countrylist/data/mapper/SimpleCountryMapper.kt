package br.com.gabrielorander.countrylist.data.mapper

import br.com.gabrielorander.countrylist.CountryListQuery
import br.com.gabrielorander.countrylist.data.model.SimpleCountry

fun CountryListQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital"
    )
}