package com.github.kazukinr.android.constraint.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.kazukinr.android.constraint.R
import com.github.kazukinr.android.constraint.databinding.MenuFragmentBinding
import com.github.kazukinr.android.constraint.sample.SampleFragmentBundle
import com.wada811.databinding.dataBinding

class MenuFragment : Fragment() {

    private val binding: MenuFragmentBinding by dataBinding(R.layout.menu_fragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listener = object : Listener {

            override fun onMenuClicked(id: Int) {
                val direction = MenuFragmentDirections.navigateToSample(
                    SampleFragmentBundle(id = id)
                )
                findNavController().navigate(direction)
            }
        }
    }

    interface Listener {

        fun onMenuClicked(id: Int)
    }
}