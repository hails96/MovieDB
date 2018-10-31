package lsh.framgia.com.moviedb.data.repository

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.remote.response.GenreResponse

class GenreRepository(
    private val local: GenreDataSource.LocalDataSource,
    private val remote: GenreDataSource.RemoteDataSource
) : GenreDataSource.LocalDataSource, GenreDataSource.RemoteDataSource {

    override fun getMovieGenres(): Single<GenreResponse> {
        return remote.getMovieGenres()
    }
}
