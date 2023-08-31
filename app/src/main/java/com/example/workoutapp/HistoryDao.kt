package com.example.workoutapp




import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {

    @Insert
    fun insertStudent(historyEntity: HistoryEntity)


    @Query("SELECT * FROM historytable")
    fun getAllStudent(): LiveData<List<HistoryEntity>>
}