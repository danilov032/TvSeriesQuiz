package com.example.tvseriesquiz.current_franchise.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.current_franchise.domain.Test
import com.example.tvseriesquiz.current_franchise.presentation.adapters.TestAdapter
import com.example.tvseriesquiz.databinding.FragmentCurrentFranchiseBinding
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class CurrentFranchiseFragment : BaseFragment<FragmentCurrentFranchiseBinding>(), CurrentFranchiseView {

    @Inject
    lateinit var presenterProvider: Provider<CurrentFranchisePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private val testAdapter: TestAdapter by lazy { TestAdapter { test ->
        presenter.onClickFranchise(test)
    }}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.listTests.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = testAdapter
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(): FragmentCurrentFranchiseBinding = FragmentCurrentFranchiseBinding.inflate(layoutInflater)

    override fun updateFranchises(tests: List<Test>) {
        testAdapter.updateItems(tests)
    }
}