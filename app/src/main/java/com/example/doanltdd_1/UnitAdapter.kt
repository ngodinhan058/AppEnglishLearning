package com.example.doanltdd_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.Entity.UnitEntity

class UnitAdapter(
    private val units: List<UnitEntity>,
    private val onUnitClick: (Int) -> kotlin.Unit
) : RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {

    class UnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitName: TextView = itemView.findViewById(R.id.unit_name)
        val unitImage: ImageView = itemView.findViewById(R.id.unit_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return UnitViewHolder(view)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val unit = units[position]
        holder.unitName.text = unit.name
        holder.unitImage.setImageResource(unit.iconResId)

        holder.itemView.setOnClickListener {
            onUnitClick(unit.id)

        }

    }


    override fun getItemCount() = units.size
}
