package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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
    lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.tieuDeName)

        val databaseUtils = Database(applicationContext)
        database = databaseUtils.getDatabase()
        databaseUtils.insertUnits()
        databaseUtils.insertVocabulary()
        databaseUtils.insertGrammar()
        databaseUtils.insertQuestionGrammar()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        // Mặc định tải Units của Vocabulary
        loadUnits("vocabulary")
        setTitleText("Vocabulary")
        bottomNavigationView.selectedItemId = R.id.navigation_vocabulary

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_vocabulary -> {
                    loadUnits("vocabulary")
                    setTitleText("Vocabulary")
                    true
                }

                R.id.navigation_grammar -> {
                    loadUnits("grammar")
                    setTitleText("Grammar")
                    true
                }

                R.id.navigation_exercise -> {
                    loadUnits("exercise")
                    setTitleText("Exercise")
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
            if (allUnits.isNotEmpty()) {
                runOnUiThread {
                    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                    recyclerView.adapter = UnitAdapter(allUnits) { unitId ->
                        when (screenType) {
                            "vocabulary" -> {
                                val intent =
                                    Intent(this@MainActivity, VocabularyActivity::class.java)
                                intent.putExtra("unitId", unitId)
                                startActivity(intent)
                            }

                            "grammar" -> {
                                val intent = Intent(this@MainActivity, GrammarActivity::class.java)
                                intent.putExtra("unitId", unitId)
                                startActivity(intent)
                            }

                            "exercise" -> {
                                val intent =
                                    Intent(this@MainActivity, DoExerciseActivity::class.java)
                                intent.putExtra("unitId", unitId)
                                startActivity(intent)
                            }
                        }
                    }
                }
            } else {
                Log.d("Unit", "No units found in the database.")
            }
        }
    }

    private fun setTitleText(title: String) {
        titleTextView.text = title
    }
}