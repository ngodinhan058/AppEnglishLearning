package com.example.doanltdd_1.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doanltdd_1.Entity.QuestionGrammar

@Dao
interface QuestionGrammarDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionGrammar>)

    @Query("SELECT * FROM question_grammar WHERE unitId = :unitId")
    suspend fun getQuestionsByUnit(unitId: Int): List<QuestionGrammar>

    @Query("SELECT id FROM question_grammar")
    suspend fun getAllQuestionGrammarIds(): List<Int>

    @Query("DELETE FROM question_grammar")
    suspend fun deleteAll()
}
