package nowowiejski.m.myapp.presentation.ui.cv

import android.os.Bundle
import android.view.View
import nowowiejski.m.myapp.R
import nowowiejski.m.myapp.core.extensions.dpAsPx
import nowowiejski.m.myapp.core.layout.BlockDividerDecoration
import nowowiejski.m.myapp.databinding.FragmentMyCvBinding
import nowowiejski.m.myapp.presentation.base.BaseFragment
import nowowiejski.m.myapp.presentation.model.EventObserver
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class CvFragment : BaseFragment<FragmentMyCvBinding>(R.layout.fragment_my_cv) {

    private val viewModel: CvBaseViewModel by lifecycleScope.viewModel(this)
    private val cvAdapter: CvAdapter by lifecycleScope.inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyCvBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            myCvViewModel = viewModel
            initViews(this)
        }
        initObservers()
        viewModel.loadData()
    }

    override fun initViews(binding: FragmentMyCvBinding) {
        with(binding.recyclerView) {
            adapter = cvAdapter
            addItemDecoration(BlockDividerDecoration(12.dpAsPx))
        }
        cvAdapter.setOnClickListener { viewModel.onItemClicked(it) }
    }

    override fun initObservers() {
        viewModel.navigateToDetailAction.observe(viewLifecycleOwner, EventObserver { url ->
        })
        viewModel.cv.observe(viewLifecycleOwner) {
            cvAdapter.setData(it)
        }
    }
}