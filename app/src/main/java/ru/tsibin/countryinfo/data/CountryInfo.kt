package ru.tsibin.countryinfo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryInfo (
    @SerializedName("flags") var countryFlag: CountryFlag?,
    @SerializedName("name") var name: CountryName?,
    @SerializedName("currencies") var currencies: CurrenciesResponse,
    @SerializedName("capital") var capital: ArrayList<String>,
    @SerializedName("altSpellings") var altSpellings: ArrayList<String>,
    @SerializedName("region") var region: String? = null,
    @SerializedName("languages") var languagesResponse: LanguagesResponse?,
    @SerializedName("population") var population: Int? = null,
    @SerializedName("timezones") var timezones: ArrayList<String> = arrayListOf()
): Parcelable
