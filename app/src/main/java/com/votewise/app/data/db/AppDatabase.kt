package com.votewise.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.votewise.app.data.models.CandidateEntity

@Database(entities = [CandidateEntity::class], version = 1, exportSchema = false)  // Suppress warning
abstract class AppDatabase : RoomDatabase() {
    abstract fun candidateDao(): CandidateDao
}