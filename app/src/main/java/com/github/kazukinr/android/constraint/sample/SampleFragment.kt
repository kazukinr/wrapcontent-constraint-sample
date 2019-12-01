package com.github.kazukinr.android.constraint.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.github.kazukinr.android.constraint.R
import com.github.kazukinr.android.constraint.databinding.MenuFragmentBinding
import com.github.kazukinr.android.constraint.databinding.SampleFragmentBinding
import com.wada811.databinding.dataBinding
import timber.log.Timber

class SampleFragment : Fragment() {

    private val binding: SampleFragmentBinding by dataBinding(R.layout.sample_fragment)

    private val args: SampleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SampleAdapter(args.bundle.id).also {
            it.submitList(prepareTestData())
            binding.recycler.adapter = it
        }
    }

    private fun prepareTestData(): List<SampleAdapter.Param> =
        listOf(
            SampleAdapter.Param(
                text1 = requireContext().getString(R.string.sample_text_1_1),
                text2 = requireContext().getString(R.string.sample_text_1_2)
            ),
            SampleAdapter.Param(
                text1 = requireContext().getString(R.string.sample_text_2_1),
                text2 = requireContext().getString(R.string.sample_text_2_2)
            )
        )
}
