package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentMainBinding
import ru.tsibin.countryinfo.mainActivity

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)
        setListeners()
        return binding.root
    }

    private fun setListeners(){
        binding.apply {
            tvByName.setOnClickListener {
                mainActivity.startSearch(SearchType.BY_NAME)
            }

            tvByCurrency.setOnClickListener {
                mainActivity.startSearch(SearchType.BY_CURRENCY)
            }

            tvByCapital.setOnClickListener {
                mainActivity.startSearch(SearchType.BY_CAPITAL)
            }
        }
    }



    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}