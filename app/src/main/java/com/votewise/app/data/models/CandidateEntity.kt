package com.votewise.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "candidates")
@TypeConverters(PositionsConverter::class, DonorsConverter::class)
data class CandidateEntity(
    @PrimaryKey val id: String,
    val name: String,
    val party: String,
    val bio: String?,
    val positions: List<String>,
    val donors: List<Donor>
)

class PositionsConverter {
    private val gson = Gson()
    @androidx.room.TypeConverter
    fun fromList(list: List<String>): String = gson.toJson(list)
    @androidx.room.TypeConverter
    fun toList(json: String): List<String> = gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
}

class DonorsConverter {
    private val gson = Gson()
    @androidx.room.TypeConverter
    fun fromList(list: List<Donor>): String = gson.toJson(list)
    @androidx.room.TypeConverter
    fun toList(json: String): List<Donor> = gson.fromJson(json, object : TypeToken<List<Donor>>() {}.type)
}