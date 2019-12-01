package com.github.kazukinr.android.constraint.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.kazukinr.android.constraint.R
import com.github.kazukinr.android.constraint.databinding.MenuFragmentBinding
import com.wada811.databinding.dataBinding
import timber.log.Timber

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
                Timber.i("onMenuClicked: $id")
            }
        }
    }

    interface Listener {

        fun onMenuClicked(id: Int)
    }
}