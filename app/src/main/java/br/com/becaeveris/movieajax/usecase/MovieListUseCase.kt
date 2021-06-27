package br.com.becaeveris.movieajax.usecase

import br.com.becaeveris.movieajax.data.MovieRepository
import br.com.becaeveris.movieajax.data.MovieRepositoryDetails

//import br.com.becaeveris.movieajax.data.MovieRepositoryDetails

class MovieListUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}

class MovieUseCaseDetails(private val movieRepositoryDetails: MovieRepositoryDetails){
    operator fun invoke() = movieRepositoryDetails.getMovieFromDataSourceDetails()
}
