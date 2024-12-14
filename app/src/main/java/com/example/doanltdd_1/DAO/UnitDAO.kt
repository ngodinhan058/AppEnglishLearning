package com.example.doanltdd_1.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doanltdd_1.Entity.UnitEntity

@Dao
interface UnitDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnits(units: List<UnitEntity>)

    @Query("SELECT * FROM units")
    suspend fun getAllUnits(): List<UnitEntity>
}