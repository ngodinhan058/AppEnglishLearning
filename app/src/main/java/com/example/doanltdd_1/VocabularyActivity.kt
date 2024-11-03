package com.example.doanltdd_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView

class VocabularyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Sử dụng danh sách Units từ DataSource
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UnitAdapter(DataSource.units)

        // Thiết lập điều hướng cho BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vocabulary -> {
                    // Current screen
                    true
                }
                R.id.navigation_grammar -> {
                    // Code to navigate to Grammar screen
                    true
                }
                R.id.navigation_exercise -> {
                    // Code to navigate to Exercise screen
                    true
                }
                else -> false
            }
        }
    }
}
