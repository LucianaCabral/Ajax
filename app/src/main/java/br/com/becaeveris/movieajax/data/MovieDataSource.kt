package br.com.becaeveris.movieajax.data

import br.com.becaeveris.movieajax.domain.Movie

interface MovieDataSource {
    fun getAllMovies():List<Movie>
}