package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Untils.Database
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseUtils = Database(applicationContext);
        database = databaseUtils.getDatabase()
        databaseUtils.getDatabase()
//        databaseUtils.insertUnits()
        databaseUtils.insertVocabulary( )
        
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        GlobalScope.launch {
            val dao = database.unitDao()
            val allUnits = dao.getAllUnits()
            Log.d("Unit", allUnits.toString())
            // Ensure the list is not empty
            if (allUnits.isNotEmpty()) {
                // Update the UI on the main thread
                runOnUiThread {
                    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = UnitAdapter(allUnits) { unitId ->
                        // Handle item clicks
                        val intent = Intent(this@MainActivity, VocabularyActivity::class.java)
                        intent.putExtra("unitId", unitId)
                        startActivity(intent)
                    }
                }
            } else {
                Log.d("Unit", "No units found in the database.")
            }
        }

        // Thiết lập điều hướng cho BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vocabulary -> {
                    // Màn hình hiện tại
                    val intent = Intent(this, VocabularyActivity::class.java)
                    startActivity(intent)
                    true

                }
                R.id.navigation_grammar -> {
                    // Chuyển đến màn hình Grammar
                    true
                }
                R.id.navigation_exercise -> {
                    // Chuyển đến màn hình Exercise

                    val intent = Intent(this, ListUnitExerciseActivity::class.java)
                    startActivity(intent)
                    true

                }
                else -> false
            }
        }
    }
}
