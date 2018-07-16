package com.example.ktmovies.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ktmovies.R
import com.example.ktmovies.domain.Movie
import com.example.ktmovies.ui.view_ext.loadImageUrl

import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by danilorangel on 15/07/18.
 */
class MoviesAdapter
constructor(private val items: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false);
        return ItemViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item: Movie = items[position];
        with(holder.itemView) {
            iv_poster.loadImageUrl(item.getPoster())
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}