package com.example.ktmovies.rest.repository

import com.example.ktmovies.domain.MoviesResponse
import com.example.ktmovies.rest.Callback

/**
 * Created by danilorangel on 14/07/18.
 */
interface MoviesRepository {

    fun getLastMovies(sort: String, year: String, page: String, callback: MoviesResponseCallback)

    fun getSimilarMovies(movieId: String, callback: MoviesResponseCallback)

    interface MoviesResponseCallback : Callback<MoviesResponse>

}