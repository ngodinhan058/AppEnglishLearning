package com.example.doanltdd_1.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_grammar")
data class QuestionGrammar(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val unitId: Int, // Liên kết với Unit
    val question: String,
    val answer: String
)
