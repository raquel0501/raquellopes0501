package com.example.myapplication2.data

import android.util.Log
import com.example.myapplication2.data.cb.DataRetrieved
import com.example.myapplication2.data.model.Breeds
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "DogApi"

object DogsAPIClient {

    private val apiDog by lazy {
        setup()
    }

    @JvmOverloads
    fun getListOfBreeds(listener: DataRetrieved? = null) {
        apiDog.getBreedsList().enqueue(object : Callback<List<Breeds>> {

            override fun onResponse(call: Call<List<Breeds>>, response: Response<List<Breeds>>) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "code: " + response.code())
                    return
                }

                listener?.onDataFetchedSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<Breeds>>, t: Throwable) {
                Log.e(TAG, "Unable to get dogs breed. Error: ${t.message}")
                listener?.onDataFetchedFailed()
            }
        })
    }

    private fun setup(): DogsAPI {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create()
    }

}