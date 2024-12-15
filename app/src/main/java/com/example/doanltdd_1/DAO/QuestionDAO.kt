package com.example.doanltdd_1.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.Entity.UnitEntity

@Dao
interface QuestionDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<Question>)

    @Query("SELECT * FROM questions")
    suspend fun getAllQuestions(): List<Question>

    @Query("DELETE FROM questions")
    suspend fun deleteAll()
}