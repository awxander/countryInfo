package ru.tsibin.countryinfo.presentation

import ru.tsibin.countryinfo.data.CountryInfo

sealed interface SearchState{

    object Initial: SearchState

    object Loading: SearchState

    data class Content(val countries: List<CountryInfo>) : SearchState

    data class Error(val text: String) : SearchState
}
