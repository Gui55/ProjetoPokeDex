package com.example.projetopokedex.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.projetopokedex.R
import com.example.projetopokedex.services.model.Results
import com.example.projetopokedex.services.webservices.Requisitions
import com.example.projetopokedex.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        var requisitions = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Requisitions::class.java)

        requisitions.searchSimpleResults().enqueue(object: Callback<Results>{
            override fun onResponse(call: Call<Results>, response: Response<Results>) {

                for(i in response.body()!!.results){
                    Log.d("RESUUUUUULT", i.name+" "+i.url)
                }

            }

            override fun onFailure(call: Call<Results>, t: Throwable) {

            }

        })

    }
}