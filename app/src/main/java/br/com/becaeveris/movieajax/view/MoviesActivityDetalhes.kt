package br.com.becaeveris.movieajax.view

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.becaeveris.movieajax.R
import br.com.becaeveris.movieajax.domain.Movie
import br.com.becaeveris.movieajax.helper.SharedPreferences
import br.com.becaeveris.movieajax.viewmodel.MoviesDetailsViewModel
import coil.load
import kotlinx.android.synthetic.main.activity_movies_detalhes.*

const val MOVIE_TITULO = "extre_movie_titulo_detalhe"
const val MOVIE_IMAGEM = "extre_movie_imagem"
const val MOVIE_DESCRICAO = "extre_movie_descriçao"
const val MOVIE_DATALANCAMENTO = "extre_movie_dataLancamento"


class MoviesActivityDetalhes : AppCompatActivity() {

    private lateinit var ratingButton: RatingBar
    private lateinit var confirm_button: Button
    lateinit var moviesDetailsViewModel: MoviesDetailsViewModel
    private var idmovie: Int? = 0

    companion object{
        const val EXTRA_MOVIE:String= "EXTRA_MOVIE"
    }
    private  lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_detalhes)

        ratingButton = findViewById<View>(R.id.ratingButton) as RatingBar
        confirm_button = findViewById<View>(R.id.confirm_button) as Button

        moviesDetailsViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesDetailsViewModel::class.java)
        getExtras()
        confirm_button.setOnClickListener {
            click(it)
        }
        //sharedPreferences = SharedPreferences(this)
        moviesDetailsViewModel.init()

       //loadingVisibility(true)
        initObserver()

    }

    private fun initObserver() {
        moviesDetailsViewModel.movie.observe(this, { movieReturn ->
            for(i in movieReturn){
                if (i.id==idmovie){
                    bindViews(i)

                }
            }
        })
    }

    private fun click(view: View) {
        val ratingvalue = ratingButton.rating
        Toast.makeText(this, "Rating is" + ratingvalue, Toast.LENGTH_LONG).show()
    }
    private  fun getExtras(){
        idmovie = intent.getIntExtra(EXTRA_MOVIE, 0)
    }
    private fun bindViews(movie:Movie){
        movie_titulo_detalhe.text = movie?.titulo
        movie_descricao.text = movie?.descricao
        movie_data_lancamento.text = movie?.dataLancamento
        movie_imagem_min.load(movie.imagem){
            placeholder(R.drawable.ic_image)
            fallback(R.drawable.ic_image)
        }
    }
/*private fun loadingVisibility(isloading: Boolean) {
        progressBar.visibility = if (isloading) View.VISIBLE else View.GONE
   }*/
}


