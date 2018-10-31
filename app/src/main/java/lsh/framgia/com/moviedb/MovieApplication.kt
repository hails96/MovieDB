package lsh.framgia.com.moviedb

import android.app.Application
import lsh.framgia.com.moviedb.dimodule.repositoryModule
import lsh.framgia.com.moviedb.dimodule.viewModelModule
import org.koin.android.ext.android.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this, listOf(
                viewModelModule,
                repositoryModule
            )
        )
    }
}
