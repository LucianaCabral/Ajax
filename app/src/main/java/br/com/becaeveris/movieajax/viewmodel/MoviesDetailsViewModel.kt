package br.com.becaeveris.movieajax.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.becaeveris.movieajax.Implementation.MovieDatasourceImplementationDetails
import br.com.becaeveris.movieajax.data.MovieRepositoryDetails
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.framework.api.MovieRestApiTask
import br.com.becaeveris.movieajax.usecase.MovieUseCaseDetails

class MoviesDetailsViewModel: ViewModel() {

    companion object {
        const val TAG = "MovieDetailsRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSourceDetails = MovieDatasourceImplementationDetails(movieRestApiTask)
    private val movieDetailsRepository = MovieRepositoryDetails(movieDataSourceDetails)
    private val movieUseCaseDetails = MovieUseCaseDetails(movieDetailsRepository)

    private var _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>>
        get() = _movie

    fun init() {
        getAllMoviesDetail()

    }

    private fun getAllMoviesDetail() {
        Thread {
            try {
                _movie.postValue(movieUseCaseDetails.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }


}


