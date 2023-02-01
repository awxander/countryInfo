package ru.tsibin.countryinfo.data

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryInfoApi {

    companion object{
        const val RESPONSE_FILTER = "?fields=" +
                "name," +
                "capital," +
//                "currencies," +
                "region," +
                "continent" +
                "population"

    }

    @GET("all$RESPONSE_FILTER")
    suspend fun getAll(): List<CountryInfo>

    @GET("name/{name}$RESPONSE_FILTER")
    suspend fun getByName(@Path("name") countryName: String): CountryInfo

    @GET("currency/{currency}$RESPONSE_FILTER")
    suspend fun getByCurrencyName(@Path("currency") currencyName: String): CountryInfo

    @GET("lang/{lang}$RESPONSE_FILTER")
    suspend fun getByLanguage(@Path("lang") language: String): CountryInfo

    @GET("capital/{capital}$RESPONSE_FILTER")
    suspend fun getByCapital(@Path("capital") capital: String): CountryInfo
}