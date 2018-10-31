package lsh.framgia.com.moviedb.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {
    abstract val bindingVariable: Int
    lateinit var viewBinding: ViewBinding
    abstract val viewModel: ViewModel
    abstract val layoutId: Int

    abstract fun initComponent(viewDataBinding: ViewBinding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding.apply {
            root.isClickable = true
            initComponent(viewBinding)
            setVariable(bindingVariable, viewModel)
            setLifecycleOwner(this@BaseFragment)
            executePendingBindings()
        }
        return viewBinding.root
    }
}
