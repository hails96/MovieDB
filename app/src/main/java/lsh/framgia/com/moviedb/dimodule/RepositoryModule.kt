package lsh.framgia.com.moviedb.dimodule

import lsh.framgia.com.moviedb.data.repository.GenreRepository
import lsh.framgia.com.moviedb.data.repository.MovieRepository
import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.MovieDataSource
import lsh.framgia.com.moviedb.data.source.local.GenreLocalDataSource
import lsh.framgia.com.moviedb.data.source.local.MovieLocalDataSource
import lsh.framgia.com.moviedb.data.source.remote.GenreRemoteDataSource
import lsh.framgia.com.moviedb.data.source.remote.MovieRemoteDataSource
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val repositoryModule = module(override = true) {
    singleBy<GenreDataSource.RemoteDataSource, GenreRemoteDataSource>()
    singleBy<GenreDataSource.LocalDataSource, GenreLocalDataSource>()
    single<GenreRepository>()

    singleBy<MovieDataSource.RemoteDataSource, MovieRemoteDataSource>()
    singleBy<MovieDataSource.LocalDataSource, MovieLocalDataSource>()
    single<MovieRepository>()
}
