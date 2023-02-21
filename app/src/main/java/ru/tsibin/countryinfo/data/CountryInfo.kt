package ru.tsibin.countryinfo.data

import com.google.gson.annotations.SerializedName


data class CountryInfo(
    @SerializedName("flags") var countryFlag: CountryFlag?,
    @SerializedName("name") var name: CountryName?,
    @SerializedName("currencies") var currencies: List<Currency>,
    @SerializedName("capital") var capital: ArrayList<String>,
    @SerializedName("altSpellings") var altSpellings: ArrayList<String>,
    @SerializedName("region") var region: String? = null,
    @SerializedName("languages") var languages: Languages?,
    @SerializedName("population") var population: Int? = null,
    @SerializedName("timezones") var timezones: ArrayList<String> = arrayListOf()
)
