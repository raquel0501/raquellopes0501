package com.example.myapplication2.data

import com.example.myapplication2.data.model.Breeds
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DogsAPI {

    @Headers("x-api-key: $API_KEY")
    @GET(BREEDS)
    fun getBreedsList(): Call<List<Breeds>>
}