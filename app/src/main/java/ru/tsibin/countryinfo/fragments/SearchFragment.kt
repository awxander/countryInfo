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
import androidx.navigation.fragment.navArgs
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentSearchBinding
import kotlinx.coroutines.*
import ru.tsibin.countryinfo.data.CountryInfo
import ru.tsibin.countryinfo.data.CountryInfoRepository
import ru.tsibin.countryinfo.mainActivity

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val args: SearchFragmentArgs by navArgs()

    private val editSearchInfo get() = requireView().findViewById<EditText>(R.id.editSearchInfo)
    private val countryName get() = requireView().findViewById<TextView>(R.id.countryName)
    private val capital get() = requireView().findViewById<TextView>(R.id.capital)
    private val region get() = requireView().findViewById<TextView>(R.id.region)
    private val scrollView get() = requireView().findViewById<ScrollView>(R.id.scrollView)
    private val linearLayout get() = requireView().findViewById<LinearLayout>(R.id.linearLayout)
    private val continent get() = requireView().findViewById<TextView>(R.id.continent)
    private val population get() = requireView().findViewById<TextView>(R.id.population)
    private val searchButton get() = requireView().findViewById<TextView>(R.id.searchButton)

    private val infoRepository = CountryInfoRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchListener()
        setEditTextHint()
    }

    private fun setEditTextHint(){
        editSearchInfo.hint = getString(R.string.enter) + " " + when(args.searchType){
            SearchType.BY_NAME -> getString(R.string.name)
            SearchType.BY_CAPITAL -> getString(R.string.capital)
            SearchType.BY_CURRENCY -> getString(R.string.currency)
            SearchType.BY_LANGUAGE -> getString(R.string.language)
        }
    }



    @OptIn(DelicateCoroutinesApi::class)
    private fun setSearchListener() {
        searchButton.setOnClickListener {
            val countryInfo = GlobalScope.async {
                getInfo().first()
            }
            runBlocking {
                setCountryInfo(countryInfo.await())
            }
            showInfo()
        }
    }

    private fun setCountryInfo(countryInfo: CountryInfo) {
        countryName.text = "country: " + countryInfo.name
        capital.text = "capital: " + countryInfo.capital
        region.text = "region: " + countryInfo.region
        population.text = "population: " + countryInfo.population
    }

    private suspend fun getInfo(): List<CountryInfo> {
        val arg = editSearchInfo.text.toString()
            .replace("\\s".toRegex(),"")
            .replace("\n".toRegex(),"")
        return when (args.searchType) {
            SearchType.BY_NAME -> infoRepository.getByName(arg)
            SearchType.BY_CURRENCY -> infoRepository.getByCurrencyName(arg)
            SearchType.BY_CAPITAL -> infoRepository.getByCapital(arg)
            else -> infoRepository.getByName(arg)
        }
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