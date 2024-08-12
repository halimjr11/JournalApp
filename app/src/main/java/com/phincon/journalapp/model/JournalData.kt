package com.phincon.journalapp.model

object JournalData {
    private val journals = mutableListOf<JournalModel>()

    fun getJournalList() = journals

    fun addToList(journalModel: JournalModel) {
        journals.add(journalModel)
    }

    fun updateJournal(index: Int, newJournal: JournalModel) {
        journals[index] = newJournal
    }

    fun deleteJournal(index: Int) {
        journals.removeAt(index)
    }
}

internal fun JournalModel.addToData() = JournalData.addToList(this)