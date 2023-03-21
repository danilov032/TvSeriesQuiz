package com.example.tvseriesquiz.finish_test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.databinding.FragmentFinishTestBinding

class FinishTestFragment: BaseFragment<FragmentFinishTestBinding>() {
    override fun getViewBinding(): FragmentFinishTestBinding = FragmentFinishTestBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.next.setOnClickListener{
            binding.root.findNavController().previousBackStackEntry?.savedStateHandle?.set("key", "ansver1")
            binding.root.findNavController().popBackStack()
        }
    }
}
