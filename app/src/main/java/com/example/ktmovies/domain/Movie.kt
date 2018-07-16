package com.example.ktmovies.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by danilorangel on 7/14/18.
 */
data class Movie(

        val id: Int,

        @SerializedName("vote_count")
        val voteCount: Int,

        val video: Boolean,

        @SerializedName("vote_average")
        val voteAverage: Double,

        val title: String,

        val popularity: Double,

        @SerializedName("poster_path")
        val posterPath: String,

        @SerializedName("original_language")
        val originalLanguage: String,

        @SerializedName("original_title")
        val originalTitle: String,

        @SerializedName("genre_ids")
        val genreIds: List<Integer>,

        @SerializedName("backdrop_path")
        val backdropPath: String,

        val adult: Boolean,

        val overview: String,

        @SerializedName("release_date")
        val releaseDate: String


) : Parcelable {
        constructor(source: Parcel) : this(
                source.readInt(),
                source.readInt(),
                1 == source.readInt(),
                source.readDouble(),
                source.readString(),
                source.readDouble(),
                source.readString(),
                source.readString(),
                source.readString(),
                ArrayList<Integer>().apply { source.readList(this, Integer::class.java.classLoader) },
                source.readString(),
                1 == source.readInt(),
                source.readString(),
                source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
                writeInt(id)
                writeInt(voteCount)
                writeInt((if (video) 1 else 0))
                writeDouble(voteAverage)
                writeString(title)
                writeDouble(popularity)
                writeString(posterPath)
                writeString(originalLanguage)
                writeString(originalTitle)
                writeList(genreIds)
                writeString(backdropPath)
                writeInt((if (adult) 1 else 0))
                writeString(overview)
                writeString(releaseDate)
        }

        companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
                        override fun createFromParcel(source: Parcel): Movie = Movie(source)
                        override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
                }
        }


    fun getPoster(): String = "https://image.tmdb.org/t/p/w500" + posterPath;
}


