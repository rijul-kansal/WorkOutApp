package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workoutapp.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    var binding:ActivityHistoryBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding=ActivityHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        var database = HistorydataBase.getDatabase(this)

    }
}