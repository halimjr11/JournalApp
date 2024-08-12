package com.phincon.journalapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phincon.journalapp.model.JournalModel

class MainViewModel : ViewModel() {

    private val _journalList: MutableLiveData<List<JournalModel>> = MutableLiveData()
    val journalList = _journalList

    fun getJournalList() {
        // set live data
    }
}