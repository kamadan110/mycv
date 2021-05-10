package nowowiejski.m.myapp.presentation.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment< S : ViewDataBinding>(
    @LayoutRes layoutRes: Int
) : Fragment(layoutRes) {

    var binding: S? = null

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    open fun initObservers() {

    }

    open fun initViews(binding: S) {}
}