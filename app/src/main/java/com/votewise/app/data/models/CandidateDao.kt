package com.votewise.app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.votewise.app.data.models.CandidateEntity

@Dao
interface CandidateDao {
    @Query("SELECT * FROM candidates")
    suspend fun getAll(): List<CandidateEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(candidates: List<CandidateEntity>)
}