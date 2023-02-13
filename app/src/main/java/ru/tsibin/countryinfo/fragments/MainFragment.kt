package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentMainBinding
import ru.tsibin.countryinfo.mainActivity

class MainFragment : Fragment(R.layout.fragment_main) {


    private val tvByName get() = requireView().findViewById<TextView>(R.id.tvByName)
    private val tvByCapital get() = requireView().findViewById<TextView>(R.id.tvByCapital)
    private val tvByCurrency get() = requireView().findViewById<TextView>(R.id.tvByCurrency)
    private val tvByLanguage get() = requireView().findViewById<TextView>(R.id.tvByLanguage)
    private val tvGetAll get() = requireView().findViewById<TextView>(R.id.tvGetAll)
    private val navController get() = findNavController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun navigateToSearchFragment(searchType: SearchType){
        val action =
            MainFragmentDirections.actionMainFragmentToSearchFragment(searchType)
        navController.navigate(action)
    }

    private fun setListeners() {
        tvByName.setOnClickListener {
            navigateToSearchFragment(SearchType.BY_NAME)
        }

        tvByCapital.setOnClickListener {
            navigateToSearchFragment(SearchType.BY_CAPITAL)
        }

        tvByCurrency.setOnClickListener {
            navigateToSearchFragment(SearchType.BY_CURRENCY)
        }

        tvByLanguage.setOnClickListener {
            navigateToSearchFragment(SearchType.BY_LANGUAGE)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}