package ru.tsibin.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.countriesinfo.R
import ru.tsibin.countryinfo.data.CountryInfoRepository


class MainActivity : AppCompatActivity() {

    val countryInfoRepository = CountryInfoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        turnOffNightMode()
    }

    private fun turnOffNightMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


}