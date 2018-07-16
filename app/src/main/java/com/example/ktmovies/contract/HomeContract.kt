package com.example.ktmovies.contract

import com.example.ktmovies.domain.Movie
import com.example.ktmovies.domain.MoviesResponse

/**
 * Created by danilorangel on 15/07/18.
 */
interface HomeContract {

    interface View {
        fun setupView(response: MoviesResponse)
        fun addMoreProduct(results: List<Movie>)
    }

    interface Presenter {
        fun loadProductsFromServer(page: Int)
    }

}