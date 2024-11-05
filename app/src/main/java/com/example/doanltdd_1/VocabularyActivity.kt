package com.example.doanltdd_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.Adapter.VocabularyAdapter
import com.example.doanltdd_1.DataSource.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class VocabularyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lấy unitId từ Intent
        val unitId = intent.getIntExtra("unitId", -1)

        // Hiển thị danh sách từ vựng theo unitId
        if (unitId != -1) {
            val vocabularyList = DataSource.getVocabularyByUnitId(unitId)
            recyclerView.adapter = VocabularyAdapter(vocabularyList)
        }
    }
}


