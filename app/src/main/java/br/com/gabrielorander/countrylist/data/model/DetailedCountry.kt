package br.com.gabrielorander.countrylist.data.model

import br.com.gabrielorander.countrylist.CountryDetailQuery

data class DetailedCountry(
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String,
    val currency: String,
    val languages: List<String>,
    val continent: String,
)
