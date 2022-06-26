package com.example.countriesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countriesmvvm.model.Country

class DetailViewModel : ViewModel(){

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","örnek")
        countryLiveData.value = country
    }

}