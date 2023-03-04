package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.countriesinfo.R

class FullInfoFragment : Fragment(R.layout.fragment_full_info) {

    private val args: FullInfoFragmentArgs by navArgs()
    private val tvCountryName get() = requireView().findViewById<TextView>(R.id.tvCountryName)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setInfo()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setInfo(){
        val countryInfo = args.countryInfo
        tvCountryName.text = countryInfo.name?.commonName
    }
}