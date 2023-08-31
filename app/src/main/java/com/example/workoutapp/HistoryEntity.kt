package com.example.workoutapp


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historytable")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name: String
)