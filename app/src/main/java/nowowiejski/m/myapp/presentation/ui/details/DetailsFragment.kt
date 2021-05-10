package nowowiejski.m.myapp.presentation.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import nowowiejski.m.myapp.R
import nowowiejski.m.myapp.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment(R.layout.fragment_details) {

    val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailsBinding.bind(view)
        val webUrl = args.url
        binding.webView.loadUrl(webUrl)
    }
}