package com.example.doanltdd_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.Question

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_layout)


        // Lấy ID Unit từ intent
        val unitId = intent.getIntExtra("unitId", -1)


        // Kiểm tra nếu unitId hợp lệ
        if (unitId == -1) {
            finish() // Đóng activity nếu không có unitId
            return
        }

        // Lấy TextView hiển thị câu hỏi
        val questionText: TextView = findViewById(R.id.questionText)

        // Lấy danh sách câu hỏi từ DataSource
        val questions = getQuestionsForUnit(unitId)

        // Hiển thị câu hỏi đầu tiên (nếu có)
        questionText.text = questions.firstOrNull()?.text ?: "No questions available for this unit"
    }

    // Phương thức lấy câu hỏi dựa trên unitId từ DataSource
    private fun getQuestionsForUnit(unitId: Int): List<Question> {
        return DataSource.questions.filter { it.idUnit == unitId }
    }
}
