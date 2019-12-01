package com.github.kazukinr.android.constraint.sample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.github.kazukinr.android.constraint.databinding.SampleItemView1Binding

class SampleItemView1 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), SampleItemView {

    private val binding = SampleItemView1Binding.inflate(
        LayoutInflater.from(context),
        this,
        true
    ).also {
        it.viewData = SampleItemView.ViewData()
    }

    override fun setParam(param: SampleItemView.Param?) {
        binding.viewData?.update(param)
        binding.executePendingBindings()
    }
}