package com.example.doanltdd_1.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "units")
data class UnitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val iconResId: Int
)