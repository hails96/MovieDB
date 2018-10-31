package lsh.framgia.com.moviedb.screen.main

import android.os.Bundle
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseActivity
import lsh.framgia.com.moviedb.screen.home.HomeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?) {
        replaceFragment(
            HomeFragment.newInstance(), R.id.frame_container,
            HomeFragment::class.java.simpleName, false
        )
    }
}
