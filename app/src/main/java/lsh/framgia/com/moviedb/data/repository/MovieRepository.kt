package lsh.framgia.com.moviedb.data.repository

import io.reactivex.Single
import lsh.framgia.com.moviedb.data.source.MovieDataSource
import lsh.framgia.com.moviedb.data.source.remote.response.MovieResponse

class MovieRepository(
    private val local: MovieDataSource.LocalDataSource,
    private val remote: MovieDataSource.RemoteDataSource
) : MovieDataSource.LocalDataSource, MovieDataSource.RemoteDataSource {

    override fun getMoviesByGenre(genreId: Int, page: Int): Single<MovieResponse> {
        return remote.getMoviesByGenre(genreId, page)
    }
}
