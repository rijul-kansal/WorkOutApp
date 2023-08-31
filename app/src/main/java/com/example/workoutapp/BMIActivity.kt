package com.example.workoutapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityBmiactivityBinding
import java.math.BigDecimal
import java.math.RoundingMode


class BMIActivity : AppCompatActivity() {

    companion object {
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }

    private var currentVisibleView: String =
        METRIC_UNITS_VIEW
    private var binding: ActivityBmiactivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
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
        binding?.radiogroup?.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == R.id.metric) {
                makeVisibleMetricUnitsView()
            } else {
                makeVisibleUsUnitsView()
            }
        }
        binding?.btnCalculateUnits?.setOnClickListener {
            calculateUnits()
        }

    }

    private fun calculateUnits(){
        if (currentVisibleView == METRIC_UNITS_VIEW) {
            if (validateMetricUnits()) {
                val heightValue: Float = binding?.ht2?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue * heightValue)
                displayBMIResult(bmi)
            } else {
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        } else {
            if (validateUsUnits()) {

                val usUnitHeightValueFeet: String =
                    binding?.etHeight1?.text.toString()
                val usUnitHeightValueInch: String =
                    binding?.etHeight2?.text.toString()
                val usUnitWeightValue: Float = binding?.etWeight?.text.toString()
                    .toFloat()
                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12
                val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))
                displayBMIResult(bmi)
            } else {
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.ht1?.visibility = View.VISIBLE
        binding?.Weight?.visibility = View.VISIBLE
        binding?.Height1?.visibility = View.GONE
        binding?.Height2?.visibility = View.GONE

        binding?.ht2?.text!!.clear()
        binding?.etWeight?.text!!.clear()

        binding?.llDiplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUsUnitsView() {
        currentVisibleView = US_UNITS_VIEW
        binding?.ht1?.visibility = View.INVISIBLE
        binding?.Height1?.visibility = View.VISIBLE
        binding?.Height2?.visibility = View.VISIBLE

        binding?.etWeight?.text!!.clear()
        binding?.etHeight1?.text!!.clear()
        binding?.etHeight2?.text!!.clear()

        binding?.llDiplayBMIResult?.visibility = View.INVISIBLE
    }
    private fun validateMetricUnits(): Boolean {
        var isValid = true

        if (binding?.etWeight?.text.toString().isEmpty()) {
            isValid = false
        } else if (binding?.ht2?.text.toString().isEmpty()) {
            isValid = false
        }

        return isValid
    }
    private fun validateUsUnits(): Boolean {
        var isValid = true

        when {
            binding?.etWeight?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etHeight1?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etHeight2?.text.toString().isEmpty() -> {
                isValid = false
            }
        }

        return isValid
    }
    private fun displayBMIResult(bmi: Float) {

        val bmiLabel: String
        val bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops!You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!"
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(
                bmi,
                30f
            ) <= 0
        ) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0
        ) {
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0
        ) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        } else {
            bmiLabel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        binding?.llDiplayBMIResult?.visibility = View.VISIBLE
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription
    }
}