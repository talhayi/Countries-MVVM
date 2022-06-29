package com.example.countriesmvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countriesmvvm.R
import com.example.countriesmvvm.adapter.CountryAdapter
import com.example.countriesmvvm.util.downloadFromUrl
import com.example.countriesmvvm.util.placeholderProgressBar
import com.example.countriesmvvm.viewmodel.CountriesViewModel
import com.example.countriesmvvm.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private lateinit var viewModel : DetailViewModel
       private var detailUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            detailUuid = DetailFragmentArgs.fromBundle(it).detailUuid
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.getDataFromRoom(detailUuid)

        observeLiveData()
    }

    private fun observeLiveData() {

        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                detailCountryName.text = country.countryName
                detailCountryCapital.text = country.countryCapital
                detailCountryRegion.text = country.countryRegion
                detailCountryCurrency.text = country.countryCurrency
                detailCountryLanguage.text = country.countryLanguage
                context?.let {
                    detailCountryImage.downloadFromUrl(country.countryFlagUrl, placeholderProgressBar(it))

                }

            }
        })
    }

}