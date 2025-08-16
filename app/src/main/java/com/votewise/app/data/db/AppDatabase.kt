package com.votewise.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.votewise.app.data.models.Candidate

@Database(entities = [Candidate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // DAOs
}