package com.example.countriesmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesmvvm.R
import com.example.countriesmvvm.model.Country

class CountryAdapter(val countrylist: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        val countryNameTextView: TextView = view.findViewById(R.id.nameTextView)
        val countryRegionTextView: TextView = view.findViewById(R.id.regionTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.countryNameTextView.text = countrylist[position].countryName
        holder.countryRegionTextView.text = countrylist[position].countryRegion

    }

    override fun getItemCount(): Int {
       return countrylist.size
    }

    fun updateCountryList(newCountryList: List<Country>){

        countrylist.clear()
        countrylist.addAll(newCountryList)
        notifyDataSetChanged()
    }
}