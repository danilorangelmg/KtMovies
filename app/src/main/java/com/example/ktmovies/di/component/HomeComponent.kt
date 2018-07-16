package com.example.ktmovies.di.component

import com.example.ktmovies.di.module.HomeModule
import com.example.ktmovies.di.scope.ActivityScope
import com.example.ktmovies.ui.home.HomeActivity
import dagger.Component

/**
 * Created by danilorangel on 15/07/18.
 */
@ActivityScope
@Component(modules = arrayOf(HomeModule::class), dependencies = arrayOf(AppComponent::class))
interface HomeComponent {
    fun inject(activity: HomeActivity)
}