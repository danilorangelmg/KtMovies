package com.example.ktmovies.rest.impl

import com.example.ktmovies.domain.MoviesResponse
import com.example.ktmovies.rest.ApiCallback
import com.example.ktmovies.rest.ApiError
import com.example.ktmovies.rest.repository.MoviesRepository
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import javax.inject.Inject

/**
 * Created by danilorangel on 15/07/18.
 */
class MoviesRepositoryImpl

@Inject
constructor(private val mServiceApi: ServiceApi) : MoviesRepository {

    override fun getLastMovies(sort: String, year: String, page: String, callback: MoviesRepository.MoviesResponseCallback) {
        mServiceApi.getLastMovies(sort, year, page).enqueue(getApiCallback(callback));
    }

    override fun getSimilarMovies(movieId: String, callback: MoviesRepository.MoviesResponseCallback) {
        mServiceApi.getSimilarMovies(movieId).enqueue(getApiCallback(callback));
    }

    fun getApiCallback(callback: MoviesRepository.MoviesResponseCallback) : ApiCallback<MoviesResponse> {
        var callbackApi = object : ApiCallback<MoviesResponse>(){
            override fun onSuccess(response: MoviesResponse?) {
                callback.onSuccess(response);
            }

            override fun onError(error: ApiError) {
                callback.onError(error);
            }

        };

        return callbackApi;
    }
}