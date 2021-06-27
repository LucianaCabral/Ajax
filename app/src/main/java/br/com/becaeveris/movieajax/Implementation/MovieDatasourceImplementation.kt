package br.com.becaeveris.movieajax.Implementation

import android.util.Log
import br.com.becaeveris.movieajax.framework.api.MovieRestApiTask
import br.com.becaeveris.movieajax.data.MovieDataSource
import br.com.becaeveris.movieajax.domain.Movie

class MovieDatasourceImplementation(private val movieRestApiTask:MovieRestApiTask):MovieDataSource {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val moviesList = arrayListOf<Movie>()
    override fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()
        if (request.isSuccessful) {
            request.body()?.let {
                moviesList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return moviesList
    }
}

