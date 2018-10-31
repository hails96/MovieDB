package lsh.framgia.com.moviedb.data.source

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.remote.response.MovieResponse

interface MovieDataSource {

    interface LocalDataSource {

    }

    interface RemoteDataSource {
        fun getMoviesByGenre(genreId: Int, page: Int): Single<MovieResponse>
    }
}
