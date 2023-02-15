package ru.tsibin.countryinfo.data

import com.google.gson.annotations.SerializedName

data class CountryName(
    @SerializedName("common")
    val name : String
    )
