package com.example.ktmovies.ui.home

import com.example.ktmovies.contract.HomeContract
import com.example.ktmovies.domain.MoviesResponse
import com.example.ktmovies.rest.ApiError
import com.example.ktmovies.rest.repository.MoviesRepository
import javax.inject.Inject

/**
 * Created by danilorangel on 14/07/18.
 */

class HomePresenter

@Inject
constructor(private val mView: HomeContract.View, private val mServiceApi: MoviesRepository) : HomeContract.Presenter {

    init {
        loadProductsFromServer(1)
    }

    override fun loadProductsFromServer(page: Int) {
        mServiceApi.getLastMovies("popularity", "2018", page.toString(), object : MoviesRepository.MoviesResponseCallback {
            override fun onSuccess(data: MoviesResponse) {
                if (page == 1) {
                    mView.setupView(data)
                } else {
                    mView.addMoreProduct(data.results)
                }

            }

            override fun onError(error: ApiError) {
                println("jsjsjsjs")
            }
        })
    }
}
