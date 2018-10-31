package lsh.framgia.com.moviedb.screen.home

import lsh.framgia.com.moviedb.BR
import lsh.framgia.com.moviedb.R
import lsh.framgia.com.moviedb.base.BaseFragment
import lsh.framgia.com.moviedb.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int = BR.homeViewModel
    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home

    override fun initComponent(viewDataBinding: FragmentHomeBinding) {

    }
}
