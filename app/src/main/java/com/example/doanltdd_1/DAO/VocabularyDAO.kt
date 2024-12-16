package com.example.doanltdd_1.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doanltdd_1.Entity.Vocabulary

@Dao
interface VocabularyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vocabularies: List<Vocabulary>)

    @Query("SELECT * FROM vocabulary WHERE unitId = :unitId")
    suspend fun getVocabularyByUnitId(unitId: Int): List<Vocabulary>
}
