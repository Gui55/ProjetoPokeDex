package com.example.projetopokedex.services.webservices

import com.example.projetopokedex.services.model.Results
import retrofit2.Call
import retrofit2.http.GET

interface Requisitions {

    @GET("pokemon")
    fun searchSimpleResults(): Call<Results>

}