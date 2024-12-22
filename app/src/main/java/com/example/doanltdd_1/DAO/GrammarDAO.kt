package com.example.doanltdd_1.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doanltdd_1.Entity.Grammar
import com.example.doanltdd_1.Entity.UnitEntity

@Dao
interface GrammarDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(grammar: Grammar)
    @Insert
    suspend fun insertGrammar(grammar: List<Grammar>)

    @Query("SELECT * FROM grammar WHERE unitId = :unitId")
    suspend fun getGrammarByUnit(unitId: Int): List<Grammar>

    @Query("DELETE FROM grammar")
    suspend fun deleteAll()
    @Query("SELECT id FROM grammar")
    suspend fun getAllGrammarIds(): List<Int>
}
