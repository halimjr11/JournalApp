package com.phincon.journalapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JournalModel(
    val title: String = "",
    val desc: String = "",
    val color: String = ""
) : Parcelable
