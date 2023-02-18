package com.example.tvseriesquiz.franchise.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.databinding.FragmentFranchiseBinding
import com.example.tvseriesquiz.di.components.DaggerAppComponent
import com.example.tvseriesquiz.di.modules.AppModule
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class FranchisesFragment : BaseFragment<FragmentFranchiseBinding>(), FranchisesView {

    @Inject
    lateinit var presenterProvider: Provider<FranchisesPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    companion object {
        @JvmStatic
        fun newInstance() = FranchisesFragment()
    }

    override fun getViewBinding(): FragmentFranchiseBinding = FragmentFranchiseBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.setOnClickListener {
//            it.findNavController().navigate(R.id.currentFranchiseFragment)
            presenter.ok()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun ok() {
        binding.text1.text = "1111111111111"
    }
}