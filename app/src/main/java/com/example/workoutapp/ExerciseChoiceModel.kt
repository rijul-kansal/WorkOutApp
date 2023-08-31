package com.example.workoutapp


class ExerciseChoiceModel(
    private var exerciseName :String,
    private var image:Int
)
{
    fun getexerciseName():String
    {
        return exerciseName
    }
    fun getimage():Int
    {
        return image
    }
}