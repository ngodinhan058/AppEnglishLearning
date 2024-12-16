package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Untils.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListUnitExerciseActivity : AppCompatActivity() {

    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_list_unit)



        val databaseUtils = Database(applicationContext);
        database = databaseUtils.getDatabase()
        databaseUtils.getDatabase()
        databaseUtils.insertUnits()
        databaseUtils.insertQuestions()


        // Use a coroutine to fetch data
        GlobalScope.launch {
            val dao = database.unitDao()
            val allUnits = dao.getAllUnits()
            Log.d("Unit", allUnits.toString())
            // Ensure the list is not empty
            if (allUnits.isNotEmpty()) {
                // Update the UI on the main thread
                runOnUiThread {
                    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this@ListUnitExerciseActivity)
                    recyclerView.adapter = UnitAdapter(allUnits) { unitId ->
                        // Handle item clicks
                        val intent = Intent(this@ListUnitExerciseActivity, DoExerciseActivity::class.java)
                        intent.putExtra("unitId", unitId)
                        startActivity(intent)
                    }
                }
            } else {
                Log.d("Unit", "No units found in the database.")
            }
        }
    }
}
