package com.example.workoutapp


class ExerciseNameModel(
    private var isseleted:Boolean,
    private var iscompleted:Boolean,
    private  var ExerciseName:String,
    private  var ExerciseGif:Int
)
{
    fun getExerciseName():String
    {
        return ExerciseName
    }
    fun getExerciseGif():Int
    {
        return ExerciseGif
    }
    fun getiscompleted():Boolean
    {
        return iscompleted
    }
    fun getisselected():Boolean
    {
        return isseleted
    }
}