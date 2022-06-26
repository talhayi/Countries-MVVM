package com.example.countriesmvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesmvvm.R
import com.example.countriesmvvm.adapter.CountryAdapter
import com.example.countriesmvvm.viewmodel.CountriesViewModel
import kotlinx.android.synthetic.main.fragment_countries.*


class CountriesFragment : Fragment() {

    private lateinit var viewModel : CountriesViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        viewModel.refreshData()

        countryRecyclerView.layoutManager = LinearLayoutManager(context)
        countryRecyclerView.adapter = countryAdapter

        observeLiveData()

    }
    private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->

            countries?.let {
                countryRecyclerView.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)

            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->

            error?.let {
                if(it){
                    countryErrorTextView.visibility = View.VISIBLE
                }
                else{
                    countryErrorTextView.visibility = View.GONE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if (it){
                    countryLoadingProgressBar.visibility = View.VISIBLE
                    countryRecyclerView.visibility = View.GONE
                    countryErrorTextView.visibility = View.GONE
                }else{

                    countryLoadingProgressBar.visibility = View.GONE
                }
            }
        })

    }

}