package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import com.example.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        binding?.Startfl?.setOnClickListener {
            var intent=Intent(this,ExerciseChoiceActivity::class.java)
            startActivity(intent)
        }
        binding?.BMI?.setOnClickListener {
            var intent=Intent(this,BMIActivity::class.java)
            startActivity(intent)
        }
        binding?.History?.setOnClickListener {
            var intent=Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}