    package br.com.becaeveris.movieajax.repository

    import android.util.Log
    import br.com.becaeveris.movieajax.framework.api.MovieRestApiTask

    /*class MovieRepository(private  val movieRestApiTask: MovieRestApiTask) {

    companion object {
    const val TAG = "MovieRepository"}
    private val moviesList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {

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
}*/