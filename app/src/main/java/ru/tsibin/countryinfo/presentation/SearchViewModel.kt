package ru.tsibin.countryinfo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.HttpException
import ru.tsibin.countryinfo.data.CountryInfoRepository

class SearchViewModel(private val repository : CountryInfoRepository) : ViewModel(){

    private val _state : MutableLiveData<SearchState> = MutableLiveData(SearchState.Initial)

    val state: LiveData<SearchState> = _state

    fun loadData(){
        try {
            val countryInfo = getInfo().first()
            setCountryInfo(countryInfo)
            showInfo()

        } catch (e: HttpException) {
            showErrorMsg(e)
        } catch (e: IllegalArgumentException) {
            showErrorMsg(e)
        }
    }
}