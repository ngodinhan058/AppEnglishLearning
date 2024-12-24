package com.example.doanltdd_1.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doanltdd_1.MainActivity
import com.example.doanltdd_1.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewScore: TextView = findViewById(R.id.textViewScore)
        val textViewCorrectAnswers: TextView = findViewById(R.id.textViewCorrectAnswers)
        val listViewResults: ListView = findViewById(R.id.listViewResults)
        val buttonBackToMain: Button = findViewById(R.id.buttonBackToMain)

        // Nhận dữ liệu từ Intent
        val score = intent.getIntExtra("score", 0)
        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val questions = intent.getStringArrayExtra("questions") ?: emptyArray()
        val answers = intent.getStringArrayExtra("answers") ?: emptyArray()
        val userAnswers = intent.getStringArrayExtra("userAnswers") ?: emptyArray()

        // Hiển thị dữ liệu
        textViewScore.text = "Point: $score"
        textViewCorrectAnswers.text = "Number of correct: $correctAnswers"

        // Hiển thị danh sách câu đúng và sai
        val results = questions.mapIndexed { index, question ->
            val status = if (userAnswers[index] == answers[index]) {
                "✅ You have chosen right!"
            } else {
                "❌ You chose wrong!"
            }
            "$question\nYour answer: ${userAnswers[index]}\nCorrect answer: ${answers[index]}\n$status"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
        listViewResults.adapter = adapter

        // Quay lại màn hình chính
        buttonBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

    }
}
