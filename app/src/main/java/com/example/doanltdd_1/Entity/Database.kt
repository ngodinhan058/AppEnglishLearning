package com.example.doanltdd_1.Entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doanltdd_1.DAO.UnitDAO
import com.example.doanltdd_1.Entity.UnitEntity

@Database(entities = [UnitEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun unitDao(): UnitDAO
}