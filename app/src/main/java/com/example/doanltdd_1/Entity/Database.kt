package com.example.doanltdd_1.Entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.doanltdd_1.DAO.QuestionDAO
import com.example.doanltdd_1.DAO.UnitDAO
import com.example.doanltdd_1.DAO.VocabularyDAO
import com.example.doanltdd_1.Entity.UnitEntity

@Database(entities = [UnitEntity::class, Question::class, Vocabulary::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun unitDao(): UnitDAO
    abstract fun questionDao(): QuestionDAO
    abstract fun vocabularyDao(): VocabularyDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Cho phép xóa và tạo lại database
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}