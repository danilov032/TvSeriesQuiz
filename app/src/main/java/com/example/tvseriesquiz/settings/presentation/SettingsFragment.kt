package com.example.tvseriesquiz.settings.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.databinding.FragmentSettingsBinding
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class SettingsFragment : BaseFragment<FragmentSettingsBinding>(), SettingsView {

    @Inject
    lateinit var presenterProvider: Provider<SettingsPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun getViewBinding(): FragmentSettingsBinding = FragmentSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.setNavigationOnClickListener{
            binding.root.findNavController().navigateUp()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
}