package br.com.becaeveris.movieajax.data

import br.com.becaeveris.movieajax.domain.Movie

interface MovieDataSourceDetails {
    fun getMovieDetail() : List<Movie>
}