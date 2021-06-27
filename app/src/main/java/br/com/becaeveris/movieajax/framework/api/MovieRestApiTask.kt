package br.com.becaeveris.movieajax.framework.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {
    companion object {
        const val  BASE_URL = "https://raw.githubusercontent.com/"
        //const val  BASE_URL = "http://Api.themoviedb.org/3/"
    }
    private  fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)

    private fun movieDetailsProvider() : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun retrofitDetailApi(): MovieDetailsApi = movieDetailsProvider().create(MovieDetailsApi::class.java)
}


