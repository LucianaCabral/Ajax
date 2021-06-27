package br.com.becaeveris.movieajax.data

class MovieRepository(private val movieDataSource: MovieDataSource) {
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
    }

class MovieRepositoryDetails(private val movieDataSourceDetails: MovieDataSourceDetails){
        fun getMovieFromDataSourceDetails() = movieDataSourceDetails.getMovieDetail()
    }
