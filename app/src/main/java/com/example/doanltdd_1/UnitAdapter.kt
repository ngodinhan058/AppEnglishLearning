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
    private val unitList: List<UnitEntity>, // Đổi tên "units" thành "unitList" để rõ nghĩa hơn
    private val onUnitClick: (Int) -> Unit // Giữ đúng chuẩn Kotlin (Unit không cần "kotlin.Unit")
) : RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {

    // ViewHolder cho từng item của RecyclerView
    class UnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitNameTextView: TextView = itemView.findViewById(R.id.unit_name)
        val unitIconImageView: ImageView = itemView.findViewById(R.id.unit_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return UnitViewHolder(view)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val unit = unitList[position] // Lấy unit theo vị trí
        holder.unitNameTextView.text = unit.name
        holder.unitIconImageView.setImageResource(unit.iconResId)

        // Xử lý khi click vào item
        holder.itemView.setOnClickListener {
            onUnitClick(unit.id)
        }
    }

    override fun getItemCount(): Int = unitList.size
}

