package com.example.doanltdd_1.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val idUnit: Int
)
