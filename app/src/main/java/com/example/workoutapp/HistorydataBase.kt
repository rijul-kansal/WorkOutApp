package com.example.workoutapp




import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [HistoryEntity::class], version = 2)
abstract class HistorydataBase : RoomDatabase() {
    abstract fun HistoryDao(): HistoryDao

    companion object {

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN isPresent INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCE: HistorydataBase? = null


        fun getDatabase(context: Context): HistorydataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        HistorydataBase::class.java,
                        "historyDB"
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }

            return INSTANCE!!
        }
    }

}