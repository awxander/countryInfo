package ru.tsibin.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.ActivityMainBinding
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countryInfoRepository = CountryInfoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    

}