package com.example.doanltdd_1.Entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doanltdd_1.DAO.GrammarDAO
import com.example.doanltdd_1.DAO.QuestionDAO
import com.example.doanltdd_1.DAO.QuestionGrammarDAO
import com.example.doanltdd_1.DAO.UnitDAO
import com.example.doanltdd_1.DAO.VocabularyDAO
import com.example.doanltdd_1.Entity.UnitEntity

@Database(entities = [UnitEntity::class, Question::class, Vocabulary::class, Grammar::class,QuestionGrammar::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun unitDao(): UnitDAO
    abstract fun questionDao(): QuestionDAO
    abstract fun vocabularyDao(): VocabularyDAO
    abstract fun grammarDao(): GrammarDAO
    abstract fun questionGrammarDao(): QuestionGrammarDAO


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}