package com.example.countriesmvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countriesmvvm.R
import com.example.countriesmvvm.databinding.FragmentDetailBinding
import com.example.countriesmvvm.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private lateinit var viewModel : DetailViewModel
       private var detailUuid = 0
    private lateinit var dataBinding : FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return dataBinding.root
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
                dataBinding.detailCountry = country
                /*
                detailCountryName.text = country.countryName
                detailCountryCapital.text = country.countryCapital
                detailCountryRegion.text = country.countryRegion
                detailCountryCurrency.text = country.countryCurrency
                detailCountryLanguage.text = country.countryLanguage
                context?.let {
                    detailCountryImage.downloadFromUrl(country.countryFlagUrl, placeholderProgressBar(it))

                }

                 */
            }
        })
    }

}