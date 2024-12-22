package com.example.doanltdd_1.Entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grammar")
data class Grammar(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val unitId: Int,
    val title: String,
    val content: String,
    val usage: String
)
