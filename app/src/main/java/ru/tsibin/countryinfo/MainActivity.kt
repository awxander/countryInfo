package ru.tsibin.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countriesinfo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.tsibin.countryinfo.data.CountryInfoRepository
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countryInfoRepository = CountryInfoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonsListeners()
    }


    private fun setButtonsListeners() {
        binding.apply {
            button.setOnClickListener {
                runBlocking {
                    launch {
                        val countryInfo = getCountryInfo()
                        textView.text = countryInfo.toString()
                    }
                }
            }
        }
    }


    private suspend fun getCountryInfo() =
        countryInfoRepository.getByName(binding.editText.text.toString())


}