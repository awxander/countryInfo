package ru.tsibin.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.ActivityMainBinding
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countryInfoRepository = CountryInfoRepository()
    private val navController get() = findNavController(R.id.fragmentHolder)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeBackgroundTransparent()
    }

    private fun makeBackgroundTransparent() {
        binding.root.background.alpha = 120
    }



}