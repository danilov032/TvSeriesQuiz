package com.example.tvseriesquiz.test.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.tvseriesquiz.BaseFragment
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.databinding.FragmentTestBinding
import com.example.tvseriesquiz.test_parrent.domain.*
import com.example.tvseriesquiz.test_parrent.presentation.KEY_ANSWER
import com.example.tvseriesquiz.test_parrent.presentation.KEY_BACK_PRESSER
import com.example.tvseriesquiz.test_parrent.presentation.TestParentPresenter
import kotlinx.android.synthetic.main.fragment_test.view.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class TestFragment : BaseFragment<FragmentTestBinding>(), TestViewState {

    @Inject
    lateinit var presenterProvider: Provider<TestPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun getViewBinding(): FragmentTestBinding = FragmentTestBinding.inflate(layoutInflater)

    private lateinit var listVariantsSingleText: List<View>
    private lateinit var listVariantsSingleImage: List<View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Вопрос 1"

        val date = arguments?.getSerializable("BASE_TEST") as BaseTest?
        val type = (arguments?.getSerializable("BASE_TEST") as BaseTest?)?.type

        binding.root.findNavController().previousBackStackEntry?.savedStateHandle?.set(KEY_ANSWER, null)
        binding.root.findNavController().previousBackStackEntry?.savedStateHandle?.set(KEY_BACK_PRESSER, null)

        presenter.checkType(date, type)
        setDefaultVar()
        initListeners()

    }

    private fun setDefaultVar() {
        listVariantsSingleText = listOf(binding.singleTextVariant1, binding.singleTextVariant2, binding.singleTextVariant3, binding.singleTextVariant4)
        listVariantsSingleImage = listOf(binding.singleImageVariant1, binding.singleImageVariant2, binding.singleImageVariant3, binding.singleImageVariant4)
    }

    private fun initListeners() {
        binding.btnComplite.setOnClickListener {
            binding.root.findNavController().previousBackStackEntry?.savedStateHandle?.set(KEY_ANSWER, "ansver1")
            binding.root.findNavController().popBackStack()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            binding.root.findNavController().previousBackStackEntry?.savedStateHandle?.set(KEY_BACK_PRESSER, true)
            binding.root.findNavController().popBackStack()
        }

        listVariantsSingleText.forEachIndexed { index, view ->
            view.setOnClickListener { presenter.clickSingleTextVariant(index) }
        }

        listVariantsSingleImage.forEachIndexed { index, view ->
            view.setOnClickListener { presenter.clickSingleImageVariant(index) }
        }
    }

    override fun setChooseStateSingleTextVariants(indexChoose: Int) {
        listVariantsSingleText.forEachIndexed { index, view ->
            if (indexChoose == index) view.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_500))
            else view.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_200))
        }
    }

    override fun showSingleTextTest(date: BaseTest.SingleTextTest) {
        binding.singleTextVariantsBlock.isVisible = true
        binding.questionText.text = date.question.text

        Glide
            .with(requireContext())
            .load(date.question.imageUrl)
            .fitCenter()
            .into(binding.questionsImage)


        binding.singleTextVariant1.text = date.inputField.variants[0].content
        binding.singleTextVariant2.text = date.inputField.variants[1].content
        binding.singleTextVariant3.text = date.inputField.variants[2].content
        binding.singleTextVariant4.text = date.inputField.variants[3].content
    }

    override fun showSingleImageTest(date: BaseTest.SingleImageTest) {
        binding.singleImageVariantsBlock.isVisible = true
        binding.questionText.text = date.question.text

        Glide
            .with(requireContext())
            .load(date.question.imageUrl)
            .fitCenter()
            .into(binding.questionsImage)

        setUrlInGlide(date.inputField.variants[0].content, binding.singleImageVariant1)
        setUrlInGlide(date.inputField.variants[0].content, binding.singleImageVariant2)
        setUrlInGlide(date.inputField.variants[0].content, binding.singleImageVariant3)
        setUrlInGlide(date.inputField.variants[0].content, binding.singleImageVariant4)
    }

    override fun setChooseStateSingleImageVariants(indexChoose: Int) {
//        listVariantsSingleText.forEachIndexed { index, view ->
//            if (indexChoose == index) view.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_500))
//            else view.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_200))
//        }
    }

    override fun enableBtnComplit(enable: Boolean) {
        binding.btnComplite.isEnabled = enable
    }

    private fun setUrlInGlide(content: String, singleImageVariant: ImageView) {
        Glide
            .with(requireContext())
            .load(content)
            .fitCenter()
            .into(singleImageVariant)
    }
}