package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.Question
import com.google.android.material.bottomnavigation.BottomNavigationView

class DoExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_layout)
        val unitId =  intent.getIntExtra("unitId", -1)
        val index = 0

        val questionText = findViewById<TextView>(R.id.questionText)
        val answer1 = findViewById<TextView>(R.id.option1)
        val answer2 = findViewById<TextView>(R.id.option2)
        val answer3 = findViewById<TextView>(R.id.option3)
        val answer4 = findViewById<TextView>(R.id.option4)
        val score = findViewById<TextView>(R.id.scoreText)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)

        val questions = mutableListOf<Question>()

        for (question in DataSource.questions) {
            if (question.idUnit == unitId) {
                questions.add(question)
            }
        }
        if (questions.isNotEmpty()) {
            val currentQuestion: Question = questions[index]
            questionText.text = currentQuestion.text
            answer1.text = currentQuestion.answers[0]
            answer2.text = currentQuestion.answers[1]
            answer3.text = currentQuestion.answers[2]
            answer4.text = currentQuestion.answers[3]
        }

    }
}
