package lsh.framgia.com.moviedb.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity<ViewModel : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initComponent(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    abstract fun initComponent(savedInstanceState: Bundle?)

    open fun addFragment(fragment: Fragment, container: Int, tag: String, addBackStack: Boolean) {
        supportFragmentManager.beginTransaction().add(container, fragment).apply {
            if (addBackStack) addToBackStack(tag)
        }.commit()
    }

    open fun replaceFragment(
        fragment: Fragment,
        container: Int,
        tag: String,
        addBackStack: Boolean
    ) {
        supportFragmentManager.beginTransaction().replace(container, fragment).apply {
            if (addBackStack) addToBackStack(tag)
        }.commit()
    }
}
