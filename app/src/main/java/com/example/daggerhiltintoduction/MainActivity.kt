package com.example.daggerhiltintoduction

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhiltintoduction.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class  MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)

        supportActionBar!!.title = "ProductList"
        val viewModel:MyViewModel by viewModels()
        Log.d("MainActivity" ,"this is it $viewModel")

        viewModel.getProductViewModel()
        viewModel.productList.observe(this , Observer {
            Log.d("MainActivity" ,  "This is the response list ${it.body()}")
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = ProductListAdapter(it.body()!!)
        })
    }

}