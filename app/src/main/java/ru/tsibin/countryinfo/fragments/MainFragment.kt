package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    private fun loadSearchFragment(searchType: SearchType){
        parentFragmentManager.beginTransaction()
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}