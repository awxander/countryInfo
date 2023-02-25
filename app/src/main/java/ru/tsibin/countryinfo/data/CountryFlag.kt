package ru.tsibin.countryinfo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryFlag(
    @SerializedName("png" ) var png : String? = null,
    @SerializedName("svg" ) var svg : String? = null,
    @SerializedName("alt" ) var alt : String? = null
) : Parcelable
