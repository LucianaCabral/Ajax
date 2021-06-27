package br.com.becaeveris.movieajax.framework.api

import br.com.becaeveris.movieajax.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieDetailsApi {
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getMovieDetail(): Call<List<Movie>>
}