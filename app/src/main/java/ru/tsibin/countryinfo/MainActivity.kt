package ru.tsibin.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.ActivityMainBinding
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.fragments.MainFragmentDirections
import ru.tsibin.countryinfo.fragments.SearchFragmentDirections
import ru.tsibin.countryinfo.fragments.SearchType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController get() = findNavController(R.id.fragmentHolder)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeBackgroundTransparent()
    }

    private fun makeBackgroundTransparent() {
        binding.root.background.alpha = 200
    }

    fun startSearch(searchType: SearchType) {
        val action = MainFragmentDirections.actionMainFragmentToSearchFragment(searchType)
        navController.navigate(action)
    }

    fun goBack() {
        val action = SearchFragmentDirections.actionSearchFragmentToMainFragment()
        navController.navigate(action)
    }




}