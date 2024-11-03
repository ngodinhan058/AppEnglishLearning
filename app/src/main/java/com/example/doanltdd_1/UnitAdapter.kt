package com.example.doanltdd_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UnitAdapter(private val units: List<String>) : RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {

    inner class UnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitIcon: ImageView = itemView.findViewById(R.id.unit_icon)
        val unitName: TextView = itemView.findViewById(R.id.unit_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return UnitViewHolder(view)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val unit = units[position]
        holder.unitName.text = unit
         holder.unitIcon.setImageResource(R.drawable.ic_hand_icon)
    }

    override fun getItemCount() = units.size
}