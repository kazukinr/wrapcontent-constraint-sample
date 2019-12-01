package com.github.kazukinr.android.constraint.sample

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(private val pattern: Int) :
    ListAdapter<SampleAdapter.Param, SampleAdapter.ViewHolder>(Param.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        when (pattern) {
            1 -> SampleItemView1(parent.context)
            else -> {
                throw IllegalArgumentException()
            }
        }.let {
            it.layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.MATCH_PARENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
            )
            ViewHolder(it)
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
