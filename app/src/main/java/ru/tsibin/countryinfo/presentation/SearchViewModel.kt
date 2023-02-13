package ru.tsibin.countryinfo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tsibin.countryinfo.data.CountryInfoRepository

class SearchViewModel(private val repository : CountryInfoRepository) : ViewModel(){

    private val _state : MutableLiveData<SearchState> = MutableLiveData(SearchState.Initial)

    val state: LiveData<SearchState> = _state

    fun loadData(){

    }
}