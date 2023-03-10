package com.example.tvseriesquiz.franchise.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.databinding.FragmentFranchiseBinding
import com.example.tvseriesquiz.franchise.domain.Franchise
import com.example.tvseriesquiz.franchise.presentation.adapters.FranchiseAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class FranchisesFragment: BaseFragment<FragmentFranchiseBinding>(), FranchisesView {

    @Inject
    lateinit var presenterProvider: Provider<FranchisesPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private val franchiseAdapter: FranchiseAdapter by lazy { FranchiseAdapter { franchise ->
        presenter.onClickFranchise(franchise)
    }}

    override fun getViewBinding(): FragmentFranchiseBinding = FragmentFranchiseBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.listFranchises.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = franchiseAdapter
        }
        setHasOptionsMenu(true)
        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.app_name)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun updateFranchises(listFranchises: List<Franchise>) {
        franchiseAdapter.updateItems(listFranchises)
    }

    override fun openCurrentFranchise(id: String, name: String) {
        val bundle = bundleOf("id" to id, "name" to name)
        binding.root.findNavController().navigate(R.id.currentFranchiseFragment, bundle)
    }
}