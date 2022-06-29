package com.example.countriesmvvm.service

import com.example.countriesmvvm.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    @GET("CountriesMVVM/countries.json")
    fun getCountries():Single<List<Country>>
}