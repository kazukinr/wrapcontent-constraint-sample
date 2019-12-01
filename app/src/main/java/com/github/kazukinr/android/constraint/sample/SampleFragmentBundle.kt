package com.github.kazukinr.android.constraint.sample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleFragmentBundle(
    val id: Int
) : Parcelable