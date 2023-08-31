package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    var binding:ActivityHistoryBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        var database = HistorydataBase.getDatabase(this)
        GlobalScope.launch {
            database.HistoryDao().getAll().collect{
                var arr=ArrayList(it)

                setup(arr)
            }
        }

    }

    private fun setup(arr: ArrayList<HistoryEntity>) {
        var ItemAdapter = HistoryAdapter(arr)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = ItemAdapter
        ItemAdapter.notifyDataSetChanged()
    }
}