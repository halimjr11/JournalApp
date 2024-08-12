package com.phincon.journalapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ManageJournalViewModel : ViewModel() {

    fun getRandomHexColor(): String {
        val red = Random.nextInt(128, 256)
        val green = Random.nextInt(128, 256)
        val blue = Random.nextInt(128, 256)

        return String.format("#%02X%02X%02X", red, green, blue)
    }
}