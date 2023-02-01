package ru.tsibin.countryinfo.data

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryInfoApi {

    @GET("/v2/all")
    suspend fun getAll(): List<CountryInfo>

    @GET("/v2/name/{name}")
    suspend fun getByName(@Path("name") countryName: String): CountryInfo

    @GET("/v2/currency/{currency}")
    suspend fun getByCurrencyName(@Path("currency") currencyName: String): CountryInfo

    @GET("/v2/lang/{lang}")
    suspend fun getByLanguage(@Path("lang") language: String): CountryInfo

    @GET("/2/capital/{capital}")
    suspend fun getByCapital(@Path("capital") capital: String): CountryInfo
}