package com.example.tvseriesquiz.current_franchise.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.current_franchise.domain.Achievement
import com.example.tvseriesquiz.current_franchise.domain.TestFromList
import com.example.tvseriesquiz.current_franchise.presentation.adapters.AchievementAdapter
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

    private val achievementAdapter: AchievementAdapter by lazy { AchievementAdapter()}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToolbar()
        binding.listTests.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = testAdapter
        }
        binding.listAchievements.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
            adapter = achievementAdapter
        }

        presenter.loadTests(arguments?.getString("id") ?: "")
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initToolbar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        val nameFranchise = arguments?.getString("name")
        (activity as? AppCompatActivity)?.supportActionBar?.title = nameFranchise
//        setHasOptionsMenu(true)
    }

    override fun getViewBinding(): FragmentCurrentFranchiseBinding = FragmentCurrentFranchiseBinding.inflate(layoutInflater)

    override fun updateFranchises(tests: List<TestFromList>) {
        testAdapter.updateItems(tests)
    }

    override fun updateAchievements(achievements: List<Achievement>) {
        achievementAdapter.updateItems(achievements)
    }

    override fun showStartTest() {
        binding.root.findNavController().navigate(R.id.startTestFragment)
    }
}