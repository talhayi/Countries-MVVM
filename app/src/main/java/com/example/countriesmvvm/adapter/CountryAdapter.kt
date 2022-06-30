package com.example.countriesmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesmvvm.R
import com.example.countriesmvvm.databinding.ItemCountryBinding
import com.example.countriesmvvm.model.Country
import com.example.countriesmvvm.view.CountriesFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countrylist: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
       //val view = inflater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countrylist[position]
        holder.view.listener = this

        /*
        holder.view.nameTextView.text =countrylist[position].countryName
        holder.view.regionTextView.text = countrylist[position].countryRegion

        holder.view.setOnClickListener {
            val action = CountriesFragmentDirections.actionCountriesFragmentToDetailFragment(countrylist[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadFromUrl(countrylist[position].countryFlagUrl,placeholderProgressBar(holder.view.context))
         */
    }

    override fun getItemCount(): Int {
       return countrylist.size
    }

    fun updateCountryList(newCountryList: List<Country>){

        countrylist.clear()
        countrylist.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryCliked(v: View) {
        val uuid = v.countryUuidTextView.text.toString().toInt()
        val action = CountriesFragmentDirections.actionCountriesFragmentToDetailFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}