package com.phincon.journalapp.viewmodel

import androidx.lifecycle.ViewModel
import com.phincon.journalapp.model.JournalData
import com.phincon.journalapp.model.JournalModel
import kotlin.random.Random

class ManageJournalViewModel : ViewModel() {

    fun addJournal(journal: JournalModel) {
        JournalData.addToList(journal)
    }

    fun updateJournal(index: Int, newJournal: JournalModel) {
        JournalData.updateJournal(index, newJournal)
    }

    fun deleteJournal(index: Int) {
        JournalData.deleteJournal(index)
    }

    fun getRandomHexColor(): String {
        val red = Random.nextInt(128, 256)
        val green = Random.nextInt(128, 256)
        val blue = Random.nextInt(128, 256)

        return String.format("#%02X%02X%02X", red, green, blue)
    }
}