package com.example.tvseriesquiz.test_parrent.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.databinding.FragmentTestParentBinding
import com.example.tvseriesquiz.test_parrent.domain.BaseTest
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider
const val KEY_ANSWER = "KEY_ANSWER"
const val KEY_BACK_PRESSER = "KEY_BACK_PRESSER"

class TestParentFragment : BaseFragment<FragmentTestParentBinding>(), TestParentView {

    @Inject
    lateinit var presenterProvider: Provider<TestParentPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun getViewBinding(): FragmentTestParentBinding = FragmentTestParentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(KEY_ANSWER)?.observe(viewLifecycleOwner) { result ->
            result?.let{ presenter.nextQuestion()}
        }

        binding.root.findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(KEY_BACK_PRESSER)?.observe(viewLifecycleOwner) { result ->
            result?.let { if (result) binding.root.findNavController().popBackStack() }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun openTest(date: BaseTest) {
        val bundle = Bundle()
        bundle.putSerializable("BASE_TEST", date)

        binding.root.findNavController().navigate(com.example.tvseriesquiz.R.id.testFragment, bundle)
    }

    override fun openFinishFragment() {
        binding.root.findNavController().popBackStack()
        binding.root.findNavController().navigate(com.example.tvseriesquiz.R.id.finishTestFragment)
    }
}