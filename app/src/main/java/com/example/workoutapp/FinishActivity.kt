package com.example.workoutapp

import com.example.workoutapp.databinding.ActivityFinishBinding


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FinishActivity : AppCompatActivity() {
    var binding:ActivityFinishBinding?=null
    var pos=0
    private lateinit var database: HistorydataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnFinish?.setOnClickListener{
            finish()
        }
        pos=intent.getIntExtra("POSITION1",0)
        Toast.makeText(this,"$pos",Toast.LENGTH_LONG).show()

        var database = HistorydataBase.getDatabase(this)

        GlobalScope.launch {
            database.HistoryDao().insert(HistoryEntity(0, "Shubham Pandey"))
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}