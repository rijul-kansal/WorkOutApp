package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        setSupportActionBar(binding?.ExerciseChoiceActivity)
        if(supportActionBar!=null)
        {
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        }

        binding?.ExerciseChoiceActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        var database = HistorydataBase.getDatabase(this)
        GlobalScope.launch {
            database.HistoryDao().getAll().collect{
                var arr=ArrayList(it)

                setup(arr)
            }
        }

    }

    private fun setup(arr: ArrayList<HistoryEntity>) {
        if(arr.size>0) {
            var ItemAdapter = HistoryAdapter(arr)
            binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
            binding?.recyclerView?.adapter = ItemAdapter
            ItemAdapter.notifyDataSetChanged()
            binding?.textView?.visibility= View.INVISIBLE
        }
        else
        {
            binding?.textView?.visibility= View.VISIBLE
            binding?.textView?.text= "No Record Found"
        }
    }
}