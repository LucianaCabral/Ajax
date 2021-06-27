package br.com.becaeveris.movieajax

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.view.ClickItemMovieListener

class MoviesViewHolder(itemView: View, var list: List<Movie>, private val Listener: ClickItemMovieListener
): RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            Listener.clickItemMovie(list[adapterPosition])
        }
    }
}