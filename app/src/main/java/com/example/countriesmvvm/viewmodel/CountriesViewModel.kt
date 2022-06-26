package com.example.countriesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countriesmvvm.model.Country

class CountriesViewModel : ViewModel(){

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","örnek")
        val country2 = Country("Turkey2","Asia2","Ankara2","TRY2","Turkish2","örnek2")
        val country3 = Country("Turkey3","Asia3","Ankara3","TRY3","Turkish3","örnek3")

        val countryList = arrayListOf<Country>(country,country2,country3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }


}