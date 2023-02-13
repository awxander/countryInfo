package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentSearchBinding
import kotlinx.coroutines.*
import retrofit2.HttpException
import ru.tsibin.countryinfo.data.CountryInfo
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.mainActivity

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val args: SearchFragmentArgs by navArgs()

    private val editSearchInfo get() = requireView().findViewById<EditText>(R.id.editSearchInfo)
    private val countryName get() = requireView().findViewById<TextView>(R.id.countryName)
    private val capital get() = requireView().findViewById<TextView>(R.id.capital)
    private val region get() = requireView().findViewById<TextView>(R.id.region)
    private val population get() = requireView().findViewById<TextView>(R.id.population)
    private val searchButton get() = requireView().findViewById<TextView>(R.id.searchButton)
    private val tvErrorMsg get() = requireView().findViewById<TextView>(R.id.errorMsg)

    private val infoRepository = CountryInfoRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchListener()
        setEditTextHint()
    }

    private fun setEditTextHint() {
        editSearchInfo.hint = getString(R.string.enter) + " " + when (args.searchType) {
            SearchType.BY_NAME -> getString(R.string.name)
            SearchType.BY_CAPITAL -> getString(R.string.capital)
            SearchType.BY_CURRENCY -> getString(R.string.currency)
            SearchType.BY_LANGUAGE -> getString(R.string.language)
        }
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun setSearchListener() {
        searchButton.setOnClickListener {

            lifecycleScope.launch {

            }
        }
    }

    private fun showErrorMsg(e: Exception) {
        val errorMsg = getString(R.string.error) + ": " + e.message
        tvErrorMsg.visibility = View.VISIBLE
        tvErrorMsg.text = errorMsg
    }

    private fun setCountryInfo(countryInfo: CountryInfo) {
        countryName.text = "country: " + countryInfo.name
        capital.text = "capital: " + countryInfo.capital
        region.text = "region: " + countryInfo.region
        population.text = "population: " + countryInfo.population
    }

    private suspend fun getInfo(): List<CountryInfo> {
        val arg = handleInput()
        return when (args.searchType) {
            SearchType.BY_NAME -> infoRepository.getByName(arg)
            SearchType.BY_CURRENCY -> infoRepository.getByCurrencyName(arg)
            SearchType.BY_CAPITAL -> infoRepository.getByCapital(arg)
            SearchType.BY_LANGUAGE -> infoRepository.getByCapital(arg)
        }
    }

    private fun handleInput(): String {
        val res = editSearchInfo.text.toString()
            .replace("\\s".toRegex(), "")
            .replace("\n".toRegex(), "")

        if (res == "") {
            throw IllegalArgumentException("wrong input, try again")
        }
        return res
    }

    private fun showInfo() {
        countryName.visibility = View.VISIBLE
        capital.visibility = View.VISIBLE
        region.visibility = View.VISIBLE
        population.visibility = View.VISIBLE

    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}