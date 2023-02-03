package ru.tsibin.countryinfo

import androidx.fragment.app.Fragment

val Fragment.mainActivity: MainActivity
    get() = requireActivity() as MainActivity