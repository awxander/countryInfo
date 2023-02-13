package ru.tsibin.countryinfo.data

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryInfoApi {

    @GET("all")
    suspend fun getAll(): List<CountryInfo>

    @GET("name/{name}")
    suspend fun getByName(@Path("name") countryName: String): List<CountryInfo>

    @GET("currency/{currency}")
    suspend fun getByCurrencyName(@Path("currency") currencyName: String): List<CountryInfo>

    @GET("lang/{lang}")
    suspend fun getByLanguage(@Path("lang") language: String): List<CountryInfo>

    @GET("capital/{capital}")
    suspend fun getByCapital(@Path("capital") capital: String): List<CountryInfo>
}