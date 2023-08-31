package com.example.workoutapp


import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.workoutapp.databinding.ActivityMain2Binding
import com.example.workoutapp.databinding.CustomDialogBackbtnBinding
import java.util.Locale

class MainActivity2 : AppCompatActivity(),TextToSpeech.OnInitListener {
    var restime: CountDownTimer? = null
    var Exercisetime: CountDownTimer? = null
    var binding: ActivityMain2Binding? = null

    var ExerciseChest: ArrayList<ExerciseNameModel>? = null
    var currpos = 0
    var pos=0
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        if (supportActionBar != null) {
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        }

        binding?.Activity2tb?.setNavigationOnClickListener {
            CustomDialog()
        }

        pos=intent.getIntExtra("POSITION",0)
        when(pos) {
            0->
            {
                ExerciseChest = Contants.getExerciseChest()
            }
//            1->
//            {
//                ExerciseChest = Contants.getExerciseBack()
//            }
//            2->
//            {
//                ExerciseChest = Contants.getExerciseSholder()
//            }
//            3->
//            {
//                ExerciseChest = Contants.getExerciseLeg()
//            }
//            4->
//            {
//                ExerciseChest = Contants.getExerciseBiceps()
//            }
//            5->
//            {
//                ExerciseChest = Contants.getExerciseTriceps()
//            }
        }

        tts = TextToSpeech(this, this)
        setUpCountDownTimer_RestView_cancel()

    }

    private fun setUpCountDownTimer_RestView() {
        binding?.Activity2pb?.setProgress(100)
        binding?.Activity2pb?.setMax(10)
        restime = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding?.Activity2pb?.setProgress((millisUntilFinished / 1000).toInt())
                binding?.Activity2tv?.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                if (currpos < ExerciseChest?.size!!-1)
                    setUpCountDownTimer_ExerciseView_cancel()
                else
                {
                    var intent= Intent(this@MainActivity2,FinishActivity::class.java)
                    intent.putExtra("POSITION1",pos)
                    startActivity(intent)
                    finish()
                }
                currpos++
            }
        }.start()
    }
    private fun setUpCountDownTimer_RestView_cancel() {
        binding?.AcivityExerciseName?.visibility = View.INVISIBLE
        binding?.AcivityExerciseName2?.visibility = View.INVISIBLE
        binding?.Activity2Gif?.visibility = View.INVISIBLE
        binding?.frameLayout?.visibility = View.INVISIBLE
        binding?.frameLayoutflrest?.visibility = View.VISIBLE
        binding?.ActivityGeneral?.visibility = View.VISIBLE
        if (restime != null) {
            restime!!.cancel()
            restime = null
        }
        setUpCountDownTimer_RestView()
    }
    private fun setUpCountDownTimer_ExerciseView() {
        binding?.Activity2pbexercise?.setProgress(300)
        binding?.Activity2pbexercise?.setMax(30)
        Exercisetime = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding?.Activity2pbexercise?.setProgress((millisUntilFinished / 1000).toInt())
                binding?.Activity2tvexercise?.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                setUpCountDownTimer_RestView_cancel()
            }
        }.start()
    }
    private fun setUpCountDownTimer_ExerciseView_cancel() {
        binding?.AcivityExerciseName?.visibility = View.VISIBLE
        binding?.AcivityExerciseName2?.visibility = View.VISIBLE
        binding?.Activity2Gif?.visibility = View.VISIBLE
        binding?.frameLayout?.visibility = View.VISIBLE
        binding?.frameLayoutflrest?.visibility = View.INVISIBLE
        binding?.ActivityGeneral?.visibility = View.INVISIBLE

        binding?.AcivityExerciseName2?.text = ExerciseChest?.get(currpos!!)?.getExerciseName()
        Glide.with(this).load(ExerciseChest?.get(currpos!!)?.getExerciseGif())
            .into(binding?.Activity2Gif!!)
        if (Exercisetime != null) {

            Exercisetime!!.cancel()
            Exercisetime = null
        }
        var text = ExerciseChest?.get(currpos!!)?.getExerciseName()
        speakOut(text!!)
        setUpCountDownTimer_ExerciseView()
    }
    override fun onDestroy() {
        if (restime != null) {
            restime!!.cancel()
            restime = null
        }
        if (Exercisetime != null) {
            Exercisetime!!.cancel()
            Exercisetime = null
        }
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
        binding = null
    }
    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language not supported!")
            } else {
                // Todo
            }
        }
    }
    private fun CustomDialog() {
        var dialog= Dialog(this)
        var binding1=CustomDialogBackbtnBinding.inflate(layoutInflater)
        binding1?.root?.let { dialog.setContentView(it) }
        dialog.show()
        binding1?.tvNoBtn?.setOnClickListener {
            dialog.dismiss()
        }
        binding1?.tvYesBtn?.setOnClickListener {
            finish()
            dialog.dismiss()        }
    }
}