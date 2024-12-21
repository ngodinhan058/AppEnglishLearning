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

        val databaseUtils = Database(applicationContext)
        database = databaseUtils.getDatabase()
        databaseUtils.insertUnits()
        databaseUtils.insertVocabulary()
        databaseUtils.insertGrammar()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        // Mặc định tải Units của Vocabulary
        loadUnits("vocabulary")
        bottomNavigationView.selectedItemId = R.id.navigation_vocabulary

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vocabulary -> {
                    loadUnits("vocabulary")
                    true
                }
                R.id.navigation_grammar -> {
                    loadUnits("grammar")
                    true
                }
                R.id.navigation_exercise -> {
                    val intent = Intent(this, ListUnitExerciseActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadUnits(screenType: String) {
        GlobalScope.launch {
            val dao = database.unitDao()
            val allUnits = dao.getAllUnits()
            runOnUiThread {
                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                recyclerView.adapter = UnitAdapter(allUnits) { unitId ->
                    when (screenType) {
                        "vocabulary" -> {
                            val intent = Intent(this@MainActivity, VocabularyActivity::class.java)
                            intent.putExtra("unitId", unitId)
                            startActivity(intent)
                        }
                        "grammar" -> {
                            val intent = Intent(this@MainActivity, GrammarActivity::class.java)
                            intent.putExtra("unitId", unitId)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }

}
