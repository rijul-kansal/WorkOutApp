package com.example.workoutapp


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {

    @Insert
    fun insert(student: HistoryEntity)

    @Query("SELECT * FROM historyTable")
    fun getAll(): LiveData<List<HistoryEntity>>
}
