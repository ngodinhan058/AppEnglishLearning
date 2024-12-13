package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Thiết lập RecyclerView hiển thị danh sách các đơn vị học
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UnitAdapter(DataSource.units) { unitId ->
            // Khi một đơn vị được nhấn, điều hướng đến VocabularyActivity
            val intent = Intent(this, VocabularyActivity::class.java)
            intent.putExtra("unitId", unitId) // Truyền unitId vào VocabularyActivity
            startActivity(intent)
        }

        // Thiết lập điều hướng cho BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vocabulary -> {
                    // Màn hình hiện tại
                    true

                }
                R.id.navigation_grammar -> {
                    // Chuyển đến màn hình Grammar
                    true
                }
                R.id.navigation_exercise -> {
                    // Chuyển đến màn hình Exercise
                    true
                    val intent = Intent(this, ExerciseActivity::class.java)
                    startActivity(intent)
                    true

                }
                else -> false
            }
        }
    }
}
