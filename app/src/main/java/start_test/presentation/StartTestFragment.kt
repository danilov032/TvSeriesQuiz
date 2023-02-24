package start_test.presentation

import android.os.Bundle
import android.view.View
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.databinding.FragmentStartTestBinding

class StartTestFragment : BaseFragment<FragmentStartTestBinding>() {
    override fun getViewBinding(): FragmentStartTestBinding = FragmentStartTestBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.start.setOnClickListener {

        }
        super.onViewCreated(view, savedInstanceState)
    }
}