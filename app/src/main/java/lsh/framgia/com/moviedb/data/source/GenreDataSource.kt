package lsh.framgia.com.moviedb.data.source

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.remote.response.GenreResponse

interface GenreDataSource {

    interface LocalDataSource {

    }

    interface RemoteDataSource {
        fun getMovieGenres(): Single<GenreResponse>
    }
}
