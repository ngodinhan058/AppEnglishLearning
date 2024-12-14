package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource

class ListUnitExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_list_unit)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Thiết lập RecyclerView hiển thị danh sách các đơn vị học
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UnitAdapter(DataSource.units) { unitId ->
            // Khi một đơn vị được nhấn, điều hướng đến VocabularyActivity
            val intent = Intent(this, DoExerciseActivity::class.java)
            intent.putExtra("unitId", unitId) // Truyền unitId vào VocabularyActivity
            startActivity(intent)
        }

    }

}
