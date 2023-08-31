package com.example.workoutapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityExerciseChoiceBinding


class ExerciseChoiceActivity : AppCompatActivity() {
    var binding:ActivityExerciseChoiceBinding?=null

    var items:ArrayList<ExerciseChoiceModel>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityExerciseChoiceBinding.inflate(layoutInflater)
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
        items=Contants.getExerciseChoice()
        setUpRecycleView()


    }

    private fun setUpRecycleView()
    {
        binding?.ExerciseChoicerv?.layoutManager = LinearLayoutManager(this)
        binding?.ExerciseChoicerv?.setHasFixedSize(true)

        val ItemAdapter = ExerciseChoiceAdapter(items!!)

        // Assign ItemAdapter instance to our RecylerView
        binding?.ExerciseChoicerv?.adapter = ItemAdapter

        // Applying OnClickListener to our Adapter
        ItemAdapter.setOnClickListener(object :
            ExerciseChoiceAdapter.OnClickListener {
            override fun onClick(position: Int, model: ExerciseChoiceModel) {
                var intent= Intent(this@ExerciseChoiceActivity,MainActivity2::class.java)
                intent.putExtra("POSITION",position)
                startActivity(intent)
                finish()
            }
        })

    }
}