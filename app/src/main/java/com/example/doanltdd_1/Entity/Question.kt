package com.example.doanltdd_1.Entity

data class Question (
    val id: Int,
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val idUnit: Int
)