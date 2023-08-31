package com.example.workoutapp


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface HistoryDao {

    @Insert
    fun insert(student: HistoryEntity)

    @Query("SELECT * FROM historytable")
    fun getAll(): Flow<List<HistoryEntity>>
}
