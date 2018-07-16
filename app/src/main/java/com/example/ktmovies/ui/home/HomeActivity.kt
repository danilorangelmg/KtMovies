package com.example.ktmovies.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import butterknife.BindView
import com.example.ktmovies.KtMovieApplication
import com.example.ktmovies.R
import com.example.ktmovies.contract.HomeContract
import com.example.ktmovies.di.component.DaggerHomeComponent
import com.example.ktmovies.di.module.HomeModule
import com.example.ktmovies.domain.Movie
import com.example.ktmovies.domain.MoviesResponse
import com.example.ktmovies.ui.BaseActivity
import com.example.ktmovies.ui.adapter.MoviesAdapter
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View {

    @Inject
    lateinit var mPresenter: HomeContract.Presenter;

    @BindView(R.id.rv_movie_list)
    lateinit var rvMovieList: RecyclerView;

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar;

    @BindView(R.id.tv_toolbar_title)
    lateinit var tvToolbarTitle: TextView;

    override fun setupView(response: MoviesResponse) {
        rvMovieList.layoutManager = GridLayoutManager(this, 2)
        rvMovieList.adapter = MoviesAdapter(response.results);
    }

    override fun addMoreProduct(results: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resourceLayout(): Int {
       return R.layout.activity_main;
    }

    override fun injectThis() {
        var app: KtMovieApplication = application as KtMovieApplication
        DaggerHomeComponent.builder().homeModule(HomeModule(this)).appComponent(app.component).build().inject(this);
    }

    override fun setupToolbar() {

    }


}
