package com.example.doanltdd_1.Entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doanltdd_1.DAO.QuestionDAO
import com.example.doanltdd_1.DAO.UnitDAO
import com.example.doanltdd_1.Entity.UnitEntity

@Database(entities = [UnitEntity::class, Question::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun unitDao(): UnitDAO
    abstract fun questionDao(): QuestionDAO
}