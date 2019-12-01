package com.github.kazukinr.android.constraint.sample

import androidx.databinding.ObservableField

interface SampleItemView {

    fun setParam(param: Param?)

    interface Param {
        val text1: String
        val text2: String
    }

    class ViewData {

        val text1 = ObservableField<CharSequence>()
        val text2 = ObservableField<CharSequence>()

        fun update(param: Param?) {
            text1.set(param?.text1)
            text2.set(param?.text2)
        }
    }
}
