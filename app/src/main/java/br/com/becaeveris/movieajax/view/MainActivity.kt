package br.com.becaeveris.movieajax.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.becaeveris.movieajax.R
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movies_detalhes.*
import kotlin.math.E

class MainActivity : AppCompatActivity(), ClickItemMovieListener {

    private lateinit var movieListViewmodel: MovieViewModel
    private val rvlista: RecyclerView by lazy {
        findViewById(R.id.moviesList) }
    private var adapter = MovieAdapter(this)

    companion object {
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewmodel = ViewModelProvider.NewInstanceFactory().create(MovieViewModel::class.java)
        movieListViewmodel.init()
        //populateList()
        loadingVisibility(true)
        initObserver()
        bindview()
    }

    private fun initObserver() {
        movieListViewmodel.movieslist.observe(this, { list ->
            if (list.isNotEmpty()) {
                updateList(list)
                loadingVisibility(false)
            }

        })
    }
    fun bindview() {
        rvlista.adapter = adapter
        rvlista.layoutManager = LinearLayoutManager(this)
    }
    private fun updateList(list: List<Movie>) {
        adapter.updateAdapter(list)
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
   }

    override fun clickItemMovie(movie: Movie) {
        val intent = Intent(this, MoviesActivityDetalhes::class.java)
        intent.putExtra(EXTRA_MOVIE, movie.id)
        startActivity(intent)
    }

}

