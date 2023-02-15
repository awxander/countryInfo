package ru.tsibin.countryinfo.data

import com.google.gson.annotations.SerializedName

data class Flag(
    @SerializedName("png" ) var png : String? = null,
    @SerializedName("svg" ) var svg : String? = null,
    @SerializedName("alt" ) var alt : String? = null
)
