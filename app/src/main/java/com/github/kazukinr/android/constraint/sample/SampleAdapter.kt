package com.github.kazukinr.android.constraint.sample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(private val pattern: Int) :
    ListAdapter<SampleAdapter.Param, SampleAdapter.ViewHolder>(Param.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        findViewByPattern(parent.context, pattern)
            .let {
                it.layoutParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.MarginLayoutParams.MATCH_PARENT,
                    ViewGroup.MarginLayoutParams.WRAP_CONTENT
                )
                ViewHolder(it)
            }

    private fun findViewByPattern(context: Context, pattern: Int): View =
        when (pattern) {
            1 -> SampleItemView1(context)
            2 -> SampleItemView2(context)
            3 -> SampleItemView3(context)
            else -> {
                throw IllegalArgumentException()
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val param = getItem(position) ?: return
        holder.setParam(param)
    }

    data class Param(
        override val text1: String,
        override val text2: String
    ) : SampleItemView.Param {

        companion object {

            val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Param>() {
                override fun areItemsTheSame(oldItem: Param, newItem: Param): Boolean =
                    oldItem == newItem

                override fun areContentsTheSame(oldItem: Param, newItem: Param): Boolean =
                    oldItem == newItem
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val sampleItemView: SampleItemView = itemView as SampleItemView

        fun setParam(param: SampleItemView.Param?) {
            sampleItemView.setParam(param)
        }
    }
}
