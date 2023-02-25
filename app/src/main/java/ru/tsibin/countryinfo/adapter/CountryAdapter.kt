package ru.tsibin.countryinfo.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countriesinfo.R
import ru.tsibin.countryinfo.TAG
import ru.tsibin.countryinfo.data.CountryInfo

class CountryAdapter(
) : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    private val countries = ArrayList<CountryInfo>()

    class CountryHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val countryNameTv = item.findViewById<TextView>(R.id.countryNameTv)
        private val countryFlagImage = item.findViewById<ImageView>(R.id.countryItemImage)

        fun bind(countryInfo: CountryInfo) {
            countryNameTv.text = countryInfo.name?.commonName
            Glide.with(itemView.context)
                .load(countryInfo.countryFlag?.png) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                .error(R.drawable.main_background)
                .into(countryFlagImage)
            Log.i(javaClass.simpleName, "successful bind")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)
        Log.i(javaClass.simpleName, "call for view holder")
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        Log.i(javaClass.simpleName, "call for bind")
        holder.bind(countries[position])
        animate(holder)
    }

    override fun getItemCount(): Int {
        Log.i(javaClass.simpleName, "call for array size")
        return countries.size
    }

    private fun animate(holder : CountryHolder){
        val animation = AnimationUtils
            .loadAnimation(holder.itemView.context, R.anim.from_right)
        holder.itemView.animation = animation
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addCountry(countryInfo: CountryInfo) {
        countries.add(countryInfo)
        notifyDataSetChanged()
    }

    fun addCountryList(countries: ArrayList<CountryInfo>){

    }


}