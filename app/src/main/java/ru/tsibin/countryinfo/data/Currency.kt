package ru.tsibin.countryinfo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Currency(
    val name : String,
    val symbol : String?
): Parcelable