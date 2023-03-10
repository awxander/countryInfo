package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesinfo.R
import ru.tsibin.countryinfo.adapter.CountryAdapter
import ru.tsibin.countryinfo.data.CountryInfo

class CountriesListFragment : Fragment(R.layout.countries_list_fragment) {

    private val args: CountriesListFragmentArgs by navArgs()
    private val adapter = CountryAdapter()
    private val countriesRecyclerView
        get() = requireView().findViewById<RecyclerView>(R.id.countriesRecyclerView)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setCountriesList()
    }

    private fun setCountriesList(){
        for(countryInfo in args.countriesInfo){
            adapter.addCountry(countryInfo)
        }
    }


    private fun initRecyclerView() {
        countriesRecyclerView.adapter = adapter
        countriesRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}