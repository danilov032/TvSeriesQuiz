package com.example.tvseriesquiz.current_franchise.presentation

import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.databinding.FragmentCurrentFranchiseBinding
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class CurrentFranchiseFragment : BaseFragment<FragmentCurrentFranchiseBinding>(), CurrentFranchiseView {

    @Inject
    lateinit var presenterLazy: dagger.Lazy<CurrentFranchisePresenter>
    @InjectPresenter
    lateinit var presenter: CurrentFranchisePresenter

    companion object {
        @JvmStatic
        fun newInstance() = CurrentFranchiseFragment()
    }

    override fun getViewBinding(): FragmentCurrentFranchiseBinding = FragmentCurrentFranchiseBinding.inflate(layoutInflater)
}