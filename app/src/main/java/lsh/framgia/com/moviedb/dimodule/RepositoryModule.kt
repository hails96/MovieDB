package lsh.framgia.com.moviedb.dimodule

import lsh.framgia.com.moviedb.data.repository.GenreRepository
import lsh.framgia.com.moviedb.data.source.GenreDataSource
import lsh.framgia.com.moviedb.data.source.local.GenreLocalDataSource
import lsh.framgia.com.moviedb.data.source.remote.GenreRemoteDataSource
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val repositoryModule = module(override = true) {
    singleBy<GenreDataSource.RemoteDataSource, GenreRemoteDataSource>()
    singleBy<GenreDataSource.LocalDataSource, GenreLocalDataSource>()
    single<GenreRepository>()
}
