package com.example.doanltdd_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.Adapter.GrammarAdapter
import com.example.doanltdd_1.Entity.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GrammarActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar)

        database = AppDatabase.getDatabase(this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGrammar)
        val unitNameTextView: TextView = findViewById(R.id.textViewUnitName) // Thêm TextView trong layout
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get unitId from Intent
        val unitId = intent.getIntExtra("unitId", -1)

        // Lấy tên Unit từ database và cập nhật TextView
        GlobalScope.launch {
            val unit = database.unitDao().getUnitById(unitId)
            val grammarList = database.grammarDao().getGrammarByUnit(unitId)

            withContext(Dispatchers.Main) {
                unitNameTextView.text = unit?.name ?: "Unit không xác định"
                recyclerView.adapter = GrammarAdapter(grammarList) { grammarId ->
                    // Handle grammar item click if needed
                }
            }
        }
    }
}
