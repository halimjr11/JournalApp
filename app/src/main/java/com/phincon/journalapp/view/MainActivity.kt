package com.phincon.journalapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.phincon.journalapp.databinding.ActivityMainBinding
import com.phincon.journalapp.view.adapter.JournalListAdapter
import com.phincon.journalapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var journalAdapter: JournalListAdapter

    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        journalAdapter = JournalListAdapter()

        //vm init

        with(binding) {
            rvJournal.run {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = journalAdapter
            }
            fabAddJournal.setOnClickListener {
                Intent(this@MainActivity, JournalManagerActivity::class.java).run {
                    putExtras(
                        bundleOf(
                            JournalManagerActivity.MANAGE_SAVE_KEY to true
                        )
                    )
                    startActivity(this)
                }
            }
        }

        with(viewModel) {
            journalList.observe(this@MainActivity) {
                binding.run {
                    if (it.isNullOrEmpty()) {
                        llEmptyState.visibility = View.VISIBLE
                        rvJournal.visibility = View.GONE
                    } else {
                        // init adapter data
                        llEmptyState.visibility = View.GONE
                        rvJournal.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}