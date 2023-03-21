package com.example.tvseriesquiz.start_test.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.databinding.FragmentStartTestBinding

class StartTestFragment : BaseFragment<FragmentStartTestBinding>() {
    override fun getViewBinding(): FragmentStartTestBinding = FragmentStartTestBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.start.setOnClickListener {
            binding.root.findNavController().popBackStack()
            binding.root.findNavController().navigate(R.id.testParentFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}