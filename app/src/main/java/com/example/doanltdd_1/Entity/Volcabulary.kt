package com.example.doanltdd_1.Entity

data class Vocabulary(
    val id: Int,
    val image: Int,
    val word: String,
    val partOfSpeech: String,
    val phonetic: String,
    val meaning: String,
    val audioResId: Int,    // Store the resource ID directly
    val unitId: Int
)
