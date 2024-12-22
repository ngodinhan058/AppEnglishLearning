package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.QuestionGrammar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuestionGrammarActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private var score = 0
    private var correctAnswers = 0
    private var questionIndex = 0
    private val userAnswers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_grammar)

        database = AppDatabase.getDatabase(this)

        val questionTextView: TextView = findViewById(R.id.textView)
        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        val buttonNext: Button = findViewById(R.id.buttonNext)
        val buttonBack: Button = findViewById(R.id.buttonBack)
        val spinnerList = listOf(
            findViewById<Spinner>(R.id.spinner),
            findViewById<Spinner>(R.id.spinner2),
            findViewById<Spinner>(R.id.spinner3),
            findViewById<Spinner>(R.id.spinner4)
        )

        val unitId = intent.getIntExtra("unitId", -1)

        // Lấy bài tập từ database
        GlobalScope.launch {
            val questions = database.questionGrammarDao().getQuestionsByUnit(unitId)

            withContext(Dispatchers.Main) {
                if (questions.isNotEmpty()) {
                    // Hiển thị câu hỏi đầu tiên
                    loadQuestion(questions, questionTextView, spinnerList)
                    handleButtons(questions, questionTextView, spinnerList, buttonSubmit, buttonNext, buttonBack)
                } else {
                    questionTextView.text = "No grammar exercises found!"
                }
            }
        }
    }

    private fun loadQuestion(
        questions: List<QuestionGrammar>,
        questionTextView: TextView,
        spinnerList: List<Spinner>
    ) {
        val currentQuestion = questions[questionIndex]

        if (currentQuestion.question.isEmpty()) {
            questionTextView.text = "No question available for this exercise."
            spinnerList.forEach { spinner ->
                spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(""))
            }
            return
        }

        val questionParts = currentQuestion.question.split(" / ")

        // Hiển thị câu hỏi với số thứ tự
        questionTextView.text = "Question ${questionIndex + 1}: ${currentQuestion.question}"

        // Gán dữ liệu vào Spinner
        spinnerList.forEachIndexed { index, spinner ->
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                questionParts
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            // Hiển thị lại đáp án đã chọn (nếu có)
            val previousAnswer = userAnswers.getOrNull(questionIndex)?.split(" ")?.getOrNull(index)
            val position = adapter.getPosition(previousAnswer)
            if (position >= 0) {
                spinner.setSelection(position)
            }
        }
    }



    private fun handleButtons(
        questions: List<QuestionGrammar>,
        questionTextView: TextView,
        spinnerList: List<Spinner>,
        buttonSubmit: Button,
        buttonNext: Button,
        buttonBack: Button
    ) {
        buttonNext.setOnClickListener {
            // Lưu lại đáp án hiện tại
            saveUserAnswer(spinnerList)
            questionIndex = if (questionIndex < questions.size - 1) {
                questionIndex + 1
            } else {
                0 // Quay về câu đầu tiên nếu đang ở câu cuối
            }
            loadQuestion(questions, questionTextView, spinnerList)
        }

        buttonBack.setOnClickListener {
            // Lưu lại đáp án hiện tại
            saveUserAnswer(spinnerList)
            questionIndex = if (questionIndex > 0) {
                questionIndex - 1
            } else {
                questions.size - 1 // Quay về câu cuối nếu đang ở câu đầu
            }
            loadQuestion(questions, questionTextView, spinnerList)
        }


        buttonSubmit.setOnClickListener {
            questions.forEachIndexed { index, currentQuestion ->
                val userAnswer = if (index == questionIndex) {
                    spinnerList.joinToString(" ") { spinner ->
                        spinner.selectedItem?.toString() ?: ""
                    }
                } else {
                    userAnswers.getOrNull(index) ?: ""
                }
                if (index < userAnswers.size) {
                    userAnswers[index] = userAnswer
                } else {
                    userAnswers.add(userAnswer)
                }
                if (userAnswer == currentQuestion.answer) {
                    score += 10 // Mỗi câu đúng được cộng 10 điểm
                    correctAnswers++
                }
            }

            // Chuyển sang màn hình kết quả
            navigateToResult(questions)
        }
    }

    private fun saveUserAnswer(spinnerList: List<Spinner>) {
        val userAnswer = spinnerList.joinToString(" ") { spinner ->
            spinner.selectedItem?.toString() ?: ""
        }
        if (questionIndex < userAnswers.size) {
            userAnswers[questionIndex] = userAnswer
        } else {
            userAnswers.add(userAnswer)
        }
    }


    private fun navigateToResult(questions: List<QuestionGrammar>) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("correctAnswers", correctAnswers)
        intent.putExtra("questions", questions.map { it.question }.toTypedArray())
        intent.putExtra("answers", questions.map { it.answer }.toTypedArray())
        intent.putExtra("userAnswers", userAnswers.toTypedArray())
        startActivity(intent)
        finish()
    }
}
