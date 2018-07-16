package com.example.ktmovies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by danilorangel on 15/07/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun resourceLayout(): Int
    abstract fun injectThis()
    abstract fun setupToolbar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resourceLayout())
        onCreateAction()
        ButterKnife.bind(this)
        injectThis()
        setupToolbar()
    }

    /**
     * this method is called inside onCreate method.
     * call this if want execute any action while onCreate run
     */
    fun onCreateAction() {
        //not to do
    }
}