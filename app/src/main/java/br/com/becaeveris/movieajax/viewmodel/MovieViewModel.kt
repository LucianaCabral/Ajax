package br.com.becaeveris.movieajax.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.becaeveris.movieajax.Implementation.MovieDatasourceImplementation
import br.com.becaeveris.movieajax.framework.api.MovieRestApiTask
import br.com.becaeveris.movieajax.data.MovieRepository
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.usecase.MovieListUseCase

class MovieViewModel: ViewModel() {
    companion object {
        const val TAG = "MovieRepository"
    }
    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDatasourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)
    //private val movieListUseCase = MovieListUseCase(movieRepository)

    private var _movieslist = MutableLiveData<List<Movie>>()
     val movieslist: LiveData<List<Movie>>
     get() = _movieslist

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies() {
       Thread{
           try{
               _movieslist.postValue(movieListUseCase.invoke())
           }catch (exception: Exception) {
               Log.d(TAG, exception.message.toString())
           }
       }.start()

    }
}
/* private var listOfMovies = arrayListOf(
        Movie(
            id = 0,
            title = "Orgulho e preconceito",
            poster_path = null,
            overview = null,
            backtrop = null,
            vote_average = null,
            release_data = null
        ),
        Movie(
            id = 1,
            title = "Titanic",
            poster_path = null,
            overview = null,
            backtrop = null,
            vote_average = null,
            release_data = null
        )
    )*/