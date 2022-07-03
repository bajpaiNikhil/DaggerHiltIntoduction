package com.example.daggerhiltintoduction

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltintoduction.domain.repository.MyRepository
import com.example.daggerhiltintoduction.model.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
):ViewModel() {

    val productList : MutableLiveData<Response<List<ProductItem>>> = MutableLiveData()

    fun getProductViewModel(){
        viewModelScope.launch {
            Log.d("ProductFragment" , "From productViewModel")
            productList.value = repository.doNetworkCal()
        }
    }
}