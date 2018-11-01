package lsh.framgia.com.moviedb.util

import android.app.ProgressDialog
import android.graphics.PorterDuff
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import lsh.framgia.com.moviedb.R


private var sProgress: ProgressDialog? = null

fun showProgressDialog(activity: FragmentActivity) {
    dismissProgressDialog()

    if (sProgress != null && sProgress!!.isShowing) {
        sProgress!!.dismiss()
    } else {
        sProgress = ProgressDialog(activity)
    }

    val drawable = ProgressBar(activity).indeterminateDrawable.apply {
        mutate().setColorFilter(
            ContextCompat.getColor(activity, R.color.color_primary),
            PorterDuff.Mode.SRC_IN
        )
    }
    sProgress!!.apply {
        setMessage(activity.getString(R.string.label_loading))
        setIndeterminateDrawable(drawable)
        show()
    }
}

fun dismissProgressDialog() {
    if (sProgress != null && sProgress!!.isShowing) {
        sProgress!!.dismiss()
    }
}
