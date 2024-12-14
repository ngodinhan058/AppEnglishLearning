package com.example.doanltdd_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.UnitEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListUnitExerciseActivity : AppCompatActivity() {

    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_list_unit)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()


//        val units = listOf(
//            UnitEntity(1, "Unit 1", R.drawable.ic_hand_icon),
//            UnitEntity(2, "Unit 2", R.drawable.ic_exercise),
//            UnitEntity(3, "Unit 3", R.drawable.ic_launcher_foreground),
//            UnitEntity(4, "Unit 4", R.drawable.ic_home),
//            UnitEntity(5, "Unit 5", R.drawable.ic_grammar),
//            UnitEntity(6, "Unit 7", R.drawable.ic_launcher_foreground),
//            UnitEntity(7, "Unit 8", R.drawable.ic_launcher_foreground),
//            UnitEntity(8, "Unit 8", R.drawable.ic_launcher_foreground),
//            UnitEntity(9, "Unit 9", R.drawable.ic_launcher_foreground),
//        )
//
//        GlobalScope.launch {
//            database.unitDao().insertUnits(units)
//        }

        // Use a coroutine to fetch data
        GlobalScope.launch {
            val dao = database.unitDao()
            val allUnits = dao.getAllUnits()

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
