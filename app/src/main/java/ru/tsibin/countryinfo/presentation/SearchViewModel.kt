package ru.tsibin.countryinfo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.tsibin.countryinfo.data.CountryInfo
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.fragments.SearchType

class SearchViewModel(private val repository: CountryInfoRepository) : ViewModel() {

    private val _state: MutableLiveData<SearchState> = MutableLiveData(SearchState.Initial)

    val state: LiveData<SearchState> = _state


    fun loadData(searchType: SearchType, arg: String) {
        viewModelScope.launch {
            _state.value = SearchState.Loading
            try {
                val countriesInfo = getInfo(searchType, arg)
                _state.value = SearchState.Content(countriesInfo)
            } catch (e: HttpException) {
                _state.value = SearchState.Error(e.message())
            }
        }
    }


    fun loadAllData() {
        viewModelScope.launch {
            _state.value = SearchState.Loading
            try {
                val countriesInfo = getAllInfo()
                _state.value = SearchState.Content(countriesInfo)
            } catch (e: HttpException) {
                _state.value = SearchState.Error(e.message.orEmpty())
            }
        }
    }


    private suspend fun getInfo(searchType: SearchType, arg: String): List<CountryInfo> {
        return when (searchType) {
            SearchType.BY_NAME -> repository.getByName(arg)
            SearchType.BY_CURRENCY -> repository.getByCurrencyName(arg)
            SearchType.BY_CAPITAL -> repository.getByCapital(arg)
            SearchType.BY_LANGUAGE -> repository.getByCapital(arg)
        }
    }

    private suspend fun getAllInfo() = repository.getAll()

}