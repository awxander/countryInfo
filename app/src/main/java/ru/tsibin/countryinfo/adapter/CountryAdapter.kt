package ru.tsibin.countryinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countriesinfo.R
import ru.tsibin.countryinfo.data.CountryInfo

class CountryAdapter(
    private val countries : List<CountryInfo>
) : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {


    class CountryHolder(item: View) : RecyclerView.ViewHolder(item){

        private val countryNameTv = item.findViewById<TextView>(R.id.countryNameTv)
        private val countryFlagImage = item.findViewById<ImageView>(R.id.countryItemImage)

        fun bind(countryInfo: CountryInfo){
            countryNameTv.text = countryInfo.name?.name
            Glide.with(itemView.context).load(countryInfo.countryFlag) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                .error(R.drawable.main_background)
                .into(countryFlagImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}