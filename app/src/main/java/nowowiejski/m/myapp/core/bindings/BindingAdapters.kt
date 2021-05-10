package nowowiejski.m.myapp.core.bindings

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import nowowiejski.m.myapp.R
import nowowiejski.m.myapp.core.adapter.BindableAdapter


object BindingAdapters {
    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageUrl"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .fitCenter()
            .placeholder(R.color.gray)
            .into(imageView)
    }


    @BindingAdapter("goneUnless")
    @JvmStatic
    fun goneUnless(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

}