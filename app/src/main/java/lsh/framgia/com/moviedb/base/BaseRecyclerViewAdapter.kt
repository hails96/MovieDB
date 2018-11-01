package lsh.framgia.com.moviedb.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

abstract class BaseRecyclerViewAdapter<Data, Binding : ViewDataBinding>(callBack: DiffUtil.ItemCallback<Data>) :
    ListAdapter<Data, BaseViewHolder<Binding>>(
        AsyncDifferConfig.Builder<Data>(callBack)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Binding> {
        return BaseViewHolder(createBinding(parent, viewType))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Binding>, position: Int) {
        bindData(holder.binding, getItem(position))
        holder.binding.apply {
            root.setOnClickListener {
                onItemClick(this)
            }
            executePendingBindings()
        }
    }

    private fun createBinding(parent: ViewGroup, viewType: Int? = 0): Binding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayoutId(),
            parent,
            false
        )
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun bindData(binding: Binding, item: Data)

    abstract fun onItemClick(viewBinding: Binding)
}
