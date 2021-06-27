package br.com.becaeveris.movieajax.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.becaeveris.movieajax.MoviesViewHolder
import br.com.becaeveris.movieajax.R
import br.com.becaeveris.movieajax.domain.Movie
import coil.load
import kotlinx.android.synthetic.main.activity_movies_detalhes.view.*
import kotlinx.android.synthetic.main.movie_item_layout.view.*


class MovieAdapter(
    private val Listener:ClickItemMovieListener) : RecyclerView.Adapter<MoviesViewHolder>() {


    private val movieslist = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view, movieslist, Listener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            movieTitle.text = movieslist[position].titulo
            movieImage.load(movieslist[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }
        override fun getItemCount(): Int = movieslist.size

        fun updateAdapter(list: List<Movie>) {
            this.movieslist.clear()
            this.movieslist.addAll(list)
            notifyDataSetChanged() }
    }





