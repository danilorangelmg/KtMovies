package com.example.ktmovies.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by danilorangel on 14/07/18.
 */

data class MoviesResponse(
        val page: Int,

        @SerializedName("total_pages")
        val totalPages: Int,

        @SerializedName("total_results")
        val totalResults: Int,

        val results: List<Movie>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.createTypedArrayList(Movie.CREATOR)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
        parcel.writeInt(totalPages)
        parcel.writeInt(totalResults)
        parcel.writeTypedList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesResponse> {
        override fun createFromParcel(parcel: Parcel): MoviesResponse {
            return MoviesResponse(parcel)
        }

        override fun newArray(size: Int): Array<MoviesResponse?> {
            return arrayOfNulls(size)
        }
    }
}