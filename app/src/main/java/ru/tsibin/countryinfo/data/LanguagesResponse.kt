package ru.tsibin.countryinfo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LanguagesResponse(val languages: List<String>) : Parcelable