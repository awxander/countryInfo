package ru.tsibin.countryinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.navArgs
import com.example.countriesinfo.R
import com.example.countriesinfo.databinding.FragmentSearchBinding
import ru.tsibin.countryinfo.mainActivity

class SearchFragment : Fragment(R.layout.fragment_search) {

    //    private val args: SearchFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackButton()
    }

    private fun setBackButton() {
//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            mainActivity.goBack()
//        }
//        callback.handleOnBackPressed()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}