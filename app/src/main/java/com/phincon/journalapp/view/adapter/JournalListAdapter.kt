package com.phincon.journalapp.view.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phincon.journalapp.databinding.ItemJournalCardBinding
import com.phincon.journalapp.model.JournalModel

class JournalListAdapter : RecyclerView.Adapter<JournalListAdapter.ViewHolder>() {
    private val journals = mutableListOf<JournalModel>()
    private var onClick: ((JournalModel, Int) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<JournalModel>) {
        journals.run {
            clear()
            addAll(list)
            notifyDataSetChanged()
        }
    }

    fun setOnClickListener(action: (JournalModel, Int) -> Unit) {
        onClick = action
    }

    class ViewHolder(val binding: ItemJournalCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemJournalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = journals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val journal = journals[position]
        holder.binding.run {
            root.run {
                setCardBackgroundColor(Color.parseColor(journal.color))
                setOnClickListener {
                    onClick?.invoke(journal, position)
                }
            }
            tvJournalText.text = journal.title
        }
    }

}