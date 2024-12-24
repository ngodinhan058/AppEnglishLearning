package com.example.doanltdd_1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.Entity.Grammar
import com.example.doanltdd_1.R

class GrammarAdapter(
    private val grammarList: List<Grammar>,
    private val onGrammarClick: (Int) -> Unit
) : RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder>() {

    class GrammarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.grammarTitle)
        val content: TextView = itemView.findViewById(R.id.grammarContent)
        val usage: TextView = itemView.findViewById(R.id.grammarUsage) // Thêm TextView cho cách sử dụng
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrammarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grammar_item, parent, false)
        return GrammarViewHolder(view)
    }

    override fun onBindViewHolder(holder: GrammarViewHolder, position: Int) {
        val grammar = grammarList[position]
        holder.title.text = grammar.title
        holder.content.text = "Ví dụ : " + grammar.content
        holder.usage.text = "Cách dùng : " + grammar.usage // Hiển thị cách sử dụng

        holder.itemView.setOnClickListener {
            onGrammarClick(grammar.id)
        }
    }

    override fun getItemCount(): Int = grammarList.size
}
