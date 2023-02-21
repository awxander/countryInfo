package ru.tsibin.countryinfo.data

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CountryInfoRepository {

    companion object{
        const val BASE_URL = "https://restcountries.com/v3.1/"
        const val READ_TIMEOUT_SECONDS = 5L
        const val CONNECT_TIMEOUT_SECONDS = 5L
        const val WRITE_TIMEOUT_SECONDS = 5L
    }


    private val gson = GsonBuilder()
        .registerTypeAdapter(Currency::class.java, GsonCurrencyConverter)
        .create()

    private val type = object : TypeToken<List<Currency>>() {}.type
//че это бля
    val currencies = gson.fromJson<List<Currency>>(jsonString, type)

    private val countryInfoApi by lazy{
        retrofit.create(CountryInfoApi::class.java)
    }

    private val retrofit = Retrofit.Builder()
        .client(provideOkHttpClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    private fun provideOkHttpClient() : OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()

    suspend fun getAll(): List<CountryInfo> =
        countryInfoApi.getAll()

    suspend fun getByName(countryName: String): List<CountryInfo> =
        countryInfoApi.getByName(countryName)

    suspend fun getByCurrencyName(currencyName: String): List<CountryInfo> =
        countryInfoApi.getByCurrencyName(currencyName)

    suspend fun getByLanguage(language: String): List<CountryInfo> =
        countryInfoApi.getByLanguage(language)

    suspend fun getByCapital(capital: String): List<CountryInfo> =
        countryInfoApi.getByCapital(capital)

}