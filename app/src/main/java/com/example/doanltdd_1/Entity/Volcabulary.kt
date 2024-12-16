package com.example.doanltdd_1.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vocabulary")
data class Vocabulary(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val image: Int,
    val word: String,
    val partOfSpeech: String,
    val phonetic: String,
    val meaning: String,
    val audioResId: Int,
    val unitId: Int
)
