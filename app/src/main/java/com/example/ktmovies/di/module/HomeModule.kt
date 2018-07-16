package com.example.ktmovies.di.module

import com.example.ktmovies.contract.HomeContract
import com.example.ktmovies.rest.impl.MoviesRepositoryImpl
import com.example.ktmovies.rest.repository.MoviesRepository
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import com.example.ktmovies.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by danilorangel on 15/07/18.
 */
@Module
class HomeModule(private val mView: HomeContract.View) {

    @Provides
    fun provideView(): HomeContract.View {
        return mView
    }

    @Provides
    fun providePresenter(view: HomeContract.View, repository: MoviesRepository): HomeContract.Presenter {
        return HomePresenter(view, repository)
    }

    @Provides
    fun provideRepository(serviceApi: ServiceApi): MoviesRepository {
        return MoviesRepositoryImpl(serviceApi)
    }
}