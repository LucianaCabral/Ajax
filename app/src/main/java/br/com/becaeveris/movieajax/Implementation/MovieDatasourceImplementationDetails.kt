package br.com.becaeveris.movieajax.Implementation

import android.util.Log
import br.com.becaeveris.movieajax.data.MovieDataSourceDetails
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.framework.api.MovieRestApiTask

class MovieDatasourceImplementationDetails(private val movieRestApiTask: MovieRestApiTask):MovieDataSourceDetails {

    companion object {
        const val TAG = "MovieDetailsRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getMovieDetail(): List<Movie> {

            val request = movieRestApiTask.retrofitDetailApi().getMovieDetail().execute()
            if (request.isSuccessful) {
                request.body()?.let {
                    movieList.addAll(it)
                }

            } else {
                request.errorBody()?.let {
                    Log.d(TAG, request.toString())
                }
            }
            return movieList
        }
    }
