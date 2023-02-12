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
    private val navController get() = findNavController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        tvByName.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToSearchFragment(SearchType.BY_NAME)
            navController.navigate(action)
        }

        tvByCapital.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToSearchFragment(SearchType.BY_CAPITAL)
            navController.navigate(action)
        }

        tvByCurrency.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToSearchFragment(SearchType.BY_CURRENCY)
            navController.navigate(action)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}