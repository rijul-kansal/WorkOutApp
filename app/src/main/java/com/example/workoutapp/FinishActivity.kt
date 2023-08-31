package com.example.workoutapp

import com.example.workoutapp.databinding.ActivityFinishBinding


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar


class FinishActivity : AppCompatActivity() {
    var binding:ActivityFinishBinding?=null
    var pos=0
    var type:String?=null
    private lateinit var database: HistorydataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnFinish?.setOnClickListener{
            finish()
        }

        pos=intent.getIntExtra("POSITION1",0)
        when(pos)
        {
            0->
            {
                type="Chest"
            }
            1->
            {
                type="Back"
            }
            2->
            {
                type="Sholder"
            }
            3->
            {
                type="Leg"
            }
            4->
            {
                type="Biceps"
            }
            5->
            {
                type="Triceps"
            }
        }
        var database = HistorydataBase.getDatabase(this)
        val calendar: Calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a")
        val dateTime = simpleDateFormat.format(calendar.time)
        GlobalScope.launch {
            database.HistoryDao().insert(HistoryEntity(0, type!!,dateTime))
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}