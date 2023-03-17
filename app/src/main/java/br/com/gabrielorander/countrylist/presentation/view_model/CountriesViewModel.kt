package br.com.gabrielorander.countrylist.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gabrielorander.countrylist.data.model.DetailedCountry
import br.com.gabrielorander.countrylist.data.model.SimpleCountry
import br.com.gabrielorander.countrylist.domain.use_case.GetCountriesUseCase
import br.com.gabrielorander.countrylist.domain.use_case.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        _state.update {
            it.copy(
                countries = getCountriesUseCase.execute(),
                isLoading = false
            )
        }
    }

    private fun selectCountry(code: String) = viewModelScope.launch {
        _state.update {
            it.copy(
                selectedCountry = getCountryUseCase.execute(code)
            )
        }
    }

    private fun dismissCountryDialog() {
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }

    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailedCountry? = null
    )
}