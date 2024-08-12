package com.phincon.journalapp.view

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.phincon.journalapp.databinding.ActivityJournalManagerBinding
import com.phincon.journalapp.model.JournalModel
import com.phincon.journalapp.viewmodel.ManageJournalViewModel

class JournalManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJournalManagerBinding
    private lateinit var viewModel: ManageJournalViewModel
    private val dataIndex by lazy {
        intent.getIntExtra(MANAGE_INDEX_KEY, 0)
    }
    private val dataJournal by lazy {
        intent.getParcelableExtra(MANAGE_DATA_KEY) ?: JournalModel()
    }
    private val isEditData by lazy {
        intent.hasExtra(MANAGE_EDIT_KEY) || intent.getBooleanExtra(MANAGE_EDIT_KEY, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJournalManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //vm init

        with(binding) {
            ivDelete.isVisible = isEditData
            etJournalTitle.text = Editable.Factory.getInstance().newEditable(dataJournal.title)
            etJournalDesc.text = Editable.Factory.getInstance().newEditable(dataJournal.desc)
            ivSave.setOnClickListener {
                val title = etJournalTitle.text.toString().trim()
                val desc = etJournalDesc.text.toString()
                if (isEditData) {
                    viewModel.updateJournal(
                        dataIndex,
                        JournalModel(title, desc, dataJournal.color)
                    )
                } else {
                    viewModel.addJournal(JournalModel(title, desc, viewModel.getRandomHexColor()))
                }
                finish()
            }
            ivDelete.setOnClickListener {
                viewModel.deleteJournal(dataIndex)
                finish()
            }
        }
    }

    companion object {
        const val MANAGE_EDIT_KEY = "journal_edit_key"
        const val MANAGE_INDEX_KEY = "journal_index_key"
        const val MANAGE_SAVE_KEY = "journal_save_key"
        const val MANAGE_DATA_KEY = "journal_data_key"
    }
}