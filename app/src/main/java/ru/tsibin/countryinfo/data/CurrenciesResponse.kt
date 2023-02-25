package ru.tsibin.countryinfo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrenciesResponse(val currencies : List<Currency>) : Parcelable