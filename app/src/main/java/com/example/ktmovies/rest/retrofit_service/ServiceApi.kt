package com.example.ktmovies.rest.retrofit_service

import com.example.ktmovies.BuildConfig
import com.example.ktmovies.domain.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by danilorangel on 7/14/18.
 */
interface ServiceApi {

    @GET("discover/movie?api_key=" + BuildConfig.API_KEY + "&language=pt-BR" +
            "&include_adult=false&vote_count.gte=0")
    fun getLastMovies(@Query("sort") sort: String, @Query("primary_release_year") year: String, @Query("page") page: String): Call<MoviesResponse>

    @GET("movie/{movieId}/similar?api_key=" + BuildConfig.API_KEY + "&language=pt-BR&page=1")
    fun getSimilarMovies(@Path("movieId") movieId: String): Call<MoviesResponse>
}
