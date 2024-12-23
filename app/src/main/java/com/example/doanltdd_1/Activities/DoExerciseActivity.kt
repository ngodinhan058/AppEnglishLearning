package com.example.doanltdd_1.Activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.DataSource.Database
import com.example.doanltdd_1.MainActivity
import com.example.doanltdd_1.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DoExerciseActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var timerText: TextView
    private lateinit var scoreValue: TextView
    private lateinit var countDownTimer: CountDownTimer
    private val timerDuration: Long = 30000  // 30 seconds
    private val interval: Long = 1000
    private var score = 0
    private var index = 0
    private var questions = mutableListOf<Question>()
    private lateinit var questionLayout: LinearLayout
    private lateinit var questionText: TextView
    private lateinit var answer1: Button
    private lateinit var answer2: Button
    private lateinit var answer3: Button
    private lateinit var answer4: Button
    private lateinit var answerCorrect: TextView
    private lateinit var answerFail: TextView
    private var correctNumber = 0
    private var incorrectNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_layout)

        val databaseUtils = Database(applicationContext)
        database = databaseUtils.getDatabase()
        databaseUtils.getDatabase()

        val unitId = intent.getIntExtra("unitId", -1)

        questionText = findViewById(R.id.questionText)
        answer1 = findViewById(R.id.option1)
        answer2 = findViewById(R.id.option2)
        answer3 = findViewById(R.id.option3)
        answer4 = findViewById(R.id.option4)
        scoreValue = findViewById(R.id.scoreText)
        timerText = findViewById(R.id.timerText)
        val btnBack = findViewById<Button>(R.id.btnBack)
        questionLayout = findViewById(R.id.questionLayout)
        answerCorrect = findViewById(R.id.answerCorrect)
        answerFail = findViewById(R.id.answerFail)


        GlobalScope.launch {
            val dao = database.questionDao()
            val allQuestions = dao.getAllQuestions()
            Log.d("Question", allQuestions.toString())
            if (allQuestions.isNotEmpty()) {
                runOnUiThread {
                    for (question in allQuestions) {
                        if (question.idUnit == unitId) {
                            questions.add(question)
                        }
                    }
                    if (questions.isNotEmpty()) {
                        startCountdown()
                    } else {
                        questionText.visibility = TextView.INVISIBLE
                        answer1.visibility = TextView.INVISIBLE
                        answer2.visibility = TextView.INVISIBLE
                        answer3.visibility = TextView.INVISIBLE
                        answer4.visibility = TextView.INVISIBLE
                    }
                }
            } else {
                Log.d("Question", "No question found in the database.")
            }
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startCountdown() {
        if (questions.isEmpty()) return

        updateQuestion()

        countDownTimer = object : CountDownTimer(timerDuration, interval) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerText.text = "Time: $seconds sec"
            }

            override fun onFinish() {
                incorrectNumber++
                index++
                if (index < questions.size) {
                    updateQuestion()
                    startCountdown()  // restart the countdown for the next question
                } else {
                    timerText.text = "Finished!"
                    questionText.text = "Quiz Completed!"
                    questionLayout.visibility = LinearLayout.GONE
                    answerCorrect.text = "Correct: ${correctNumber}"
                    answerFail.text = "Incorrect: ${incorrectNumber}"
                }
            }
        }
        countDownTimer.start()
    }

    private fun updateQuestion(

    ) {
        val currentQuestion = questions[index]
        questionText.text = "Question ${index + 1}:  " +  currentQuestion.text
        answer1.text = currentQuestion.answers[0]
        answer2.text = currentQuestion.answers[1]
        answer3.text = currentQuestion.answers[2]
        answer4.text = currentQuestion.answers[3]
        answerCorrect.text = "Correct: ${correctNumber}"
        answerFail.text = "Incorrect: ${incorrectNumber}"

        // Update click listeners to check the answer
        val correctAnswer = currentQuestion.correctAnswerIndex
        val answers = listOf(answer1, answer2, answer3, answer4)
        for (i in answers.indices) {
            answers[i].setOnClickListener {
                if (i == correctAnswer) {
                    score++
                    correctNumber++
                    scoreValue.text = "Score: $score"
                }else{
                    incorrectNumber++
                }
                countDownTimer.cancel()  // stop the timer when an answer is selected
                index++
                if (index < questions.size) {
                    updateQuestion()
                    startCountdown()  // restart the countdown for the next question
                } else {
                    timerText.text = "Finished!"
                    questionLayout.visibility = LinearLayout.GONE
                    scoreValue.text = "Final Score: $score"
                    answerCorrect.text = "Correct: ${correctNumber}"
                    answerFail.text = "Incorrect: ${incorrectNumber}"
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel the timer to prevent memory leaks
        if (::countDownTimer.isInitialized) {
            countDownTimer.cancel()
        }
    }
}

