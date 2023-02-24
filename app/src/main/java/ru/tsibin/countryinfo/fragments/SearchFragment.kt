package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.countriesinfo.R
import ru.tsibin.countryinfo.data.CountryInfo
import ru.tsibin.countryinfo.mainActivity
import ru.tsibin.countryinfo.presentation.SearchState
import ru.tsibin.countryinfo.presentation.SearchViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val args: SearchFragmentArgs by navArgs()

    private val editSearchInfo get() = requireView().findViewById<EditText>(R.id.editSearchInfo)
    private val countryName get() = requireView().findViewById<TextView>(R.id.countryName)
    private val capital get() = requireView().findViewById<TextView>(R.id.capital)
    private val region get() = requireView().findViewById<TextView>(R.id.region)
    private val population get() = requireView().findViewById<TextView>(R.id.population)
    private val searchButton get() = requireView().findViewById<TextView>(R.id.searchButton)
    private val tvErrorMsg get() = requireView().findViewById<TextView>(R.id.errorMsg)
    private val navController get() = findNavController()

    private val viewModel: SearchViewModel by viewModels{
        viewModelFactory {
            initializer {
                SearchViewModel(mainActivity.countryInfoRepository)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchListener()
        setEditTextHint()
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
    }

    private fun setEditTextHint() {
        editSearchInfo.hint = getString(R.string.enter) + " " + when (args.searchType) {
            SearchType.BY_NAME -> getString(R.string.name)
            SearchType.BY_CAPITAL -> getString(R.string.capital)
            SearchType.BY_CURRENCY -> getString(R.string.currency)
            SearchType.BY_LANGUAGE -> getString(R.string.language)
        }
    }

    private fun handleState(state: SearchState){
        when(state){
            SearchState.Initial -> Unit
            SearchState.Loading -> Unit
            is SearchState.Content -> {
//                setCountryInfo(state.countries.first())
//                showInfo()
                navigateToListFragment(state.countries)
            }
            is SearchState.Error -> showErrorMsg(state.text)
        }
    }

    private fun navigateToListFragment(countries: List<CountryInfo>){
        val action = SearchFragmentDirections
            .actionSearchFragmentToCountriesListFragment(countries.toTypedArray())
        navController.navigate(action)
    }



    private fun setSearchListener() {
        searchButton.setOnClickListener {
            try {
                val arg = handleInput()
                //so data loading will update state, in which case it will invoke handleState method
                viewModel.loadData(args.searchType, arg)
            } catch (e: IllegalArgumentException) {
                showErrorMsg(e.message.orEmpty())
            }
        }
    }

    private fun showErrorMsg(msg: String) {
        val errorMsg = getString(R.string.error) + ": " + msg
        tvErrorMsg.visibility = View.VISIBLE
        tvErrorMsg.text = errorMsg
    }

    private fun setCountryInfo(countryInfo: CountryInfo) {
        countryName.text = "country: " + countryInfo.name?.name
        capital.text = "capital: " + countryInfo.capital.first()
        region.text = "region: " + countryInfo.region
        population.text = "population: " + countryInfo.population
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