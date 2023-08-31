package com.example.workoutapp

object Contants {

    fun getExerciseChoice():ArrayList<ExerciseChoiceModel>
    {
        var lis=ArrayList<ExerciseChoiceModel>()
        lis.add(ExerciseChoiceModel("Chest",R.drawable.chestimg))
        lis.add(ExerciseChoiceModel("Back",R.drawable.backimg))
        lis.add(ExerciseChoiceModel("Sholder",R.drawable.sholderimg))
        lis.add(ExerciseChoiceModel("Leg",R.drawable.legimg))
        lis.add(ExerciseChoiceModel("Biceps",R.drawable.bicips))
        lis.add(ExerciseChoiceModel("Triceps",R.drawable.triceps))
        return lis
    }

    fun getExerciseChest():ArrayList<ExerciseNameModel>
    {
        var arrlis=ArrayList<ExerciseNameModel>()

        arrlis.add(ExerciseNameModel(false,false,"10 PushUps",R.drawable.pushup))
        arrlis.add(ExerciseNameModel(false,false,"Jumping Jacks",R.drawable.jumping_jack))
        arrlis.add(ExerciseNameModel(false,false,"10 Inclined PushUps",R.drawable.encline_pushup))
        arrlis.add(ExerciseNameModel(false,false,"Jumping Jacks",R.drawable.jumping_jack))
        arrlis.add(ExerciseNameModel(false,false,"10 Declined Push_up",R.drawable.decline_push_up))
        arrlis.add(ExerciseNameModel(false,false,"Jumping Jacks",R.drawable.jumping_jack))
        arrlis.add(ExerciseNameModel(false,false,"10 PushUps",R.drawable.pushup))
        arrlis.add(ExerciseNameModel(false, false,"Mountain Climbers",R.drawable.maontain_climbing))
        return arrlis
    }
//    fun getExerciseSholder():ArrayList<ExerciseNameModel>
//    {
//        var arrlis=ArrayList<ExerciseNameModel>()
//
//        arrlis.add(ExerciseNameModel(false,false,"Cat Cow",R.drawable.cat_cow))
//        arrlis.add(ExerciseNameModel(false,false,"Front Raise",R.drawable.front_raise))
//        arrlis.add(ExerciseNameModel(false,false,"Lateral Raise",R.drawable.lateral_raise))
//        arrlis.add(ExerciseNameModel(false,false,"Plank",R.drawable.plank))
//        arrlis.add(ExerciseNameModel(false,false,"Sholder Press",R.drawable.sholder_press))
//        arrlis.add(ExerciseNameModel(false,false,"Forearm plank",R.drawable.forearm_plank))
//        arrlis.add(ExerciseNameModel(false,false,"Up Right",R.drawable.up_right))
//        arrlis.add(ExerciseNameModel(false, false,"WalkOut",R.drawable.walkout))
//        return arrlis
//    }
//    fun getExerciseBack():ArrayList<ExerciseNameModel>
//    {
//        var arrlis=ArrayList<ExerciseNameModel>()
//
//        arrlis.add(ExerciseNameModel(false,false,"Resistance band pull-apart",R.drawable.resistance_band_pull_apart))
//        arrlis.add(ExerciseNameModel(false,false,"Wide dumbbell bent-over row",R.drawable.wide_dumbbell_bent_over_row))
//        arrlis.add(ExerciseNameModel(false,false,"Super Man",R.drawable.superman))
//        arrlis.add(ExerciseNameModel(false,false," Single-arm dumbbell row",R.drawable.single_arm_dumbbell_row))
//        arrlis.add(ExerciseNameModel(false,false,"Renegade dumbbell row",R.drawable.renegade_dumbbell_row))
//        arrlis.add(ExerciseNameModel(false,false," Reverse fly",R.drawable.reverse_fly))
//        arrlis.add(ExerciseNameModel(false,false,"Pull Up",R.drawable.pullup))
//        arrlis.add(ExerciseNameModel(false, false,"Forearm plank",R.drawable.forearm_plank))
//        return arrlis
//    }
//    fun getExerciseLeg():ArrayList<ExerciseNameModel>
//    {
//        var arrlis=ArrayList<ExerciseNameModel>()
//
//        arrlis.add(ExerciseNameModel(false,false,"Squat",R.drawable.squat))
//        arrlis.add(ExerciseNameModel(false,false,"Pendulum lunges",R.drawable.pendulum_lunges))
//        arrlis.add(ExerciseNameModel(false,false,"Step ups",R.drawable.step_ups))
//        arrlis.add(ExerciseNameModel(false,false,"Jumps Sqart",R.drawable.jumps_sqart))
//        arrlis.add(ExerciseNameModel(false,false,"Hips Bridge",R.drawable.hips_bridge))
//        arrlis.add(ExerciseNameModel(false,false,"Reverse Lunges",R.drawable.reverse_lunges))
//        arrlis.add(ExerciseNameModel(false,false,"Single-leg deadlifts",R.drawable.single_leg_deadlifts))
//        arrlis.add(ExerciseNameModel(false, false,"TouchDown Jacks",R.drawable.touch_down_jacks))
//        return arrlis
//    }
//    fun getExerciseBiceps():ArrayList<ExerciseNameModel>
//    {
//        var arrlis=ArrayList<ExerciseNameModel>()
//
//        arrlis.add(ExerciseNameModel(false,false,"Wide lifted biceps curl",R.drawable.squat))
//        arrlis.add(ExerciseNameModel(false,false,"Biceps curl",R.drawable.biceps_curl))
//        arrlis.add(ExerciseNameModel(false,false,"Alternate biceps curl",R.drawable.alternate_biceps_curl))
//        arrlis.add(ExerciseNameModel(false,false,"Hammer curl",R.drawable.hammer_curl))
//        arrlis.add(ExerciseNameModel(false,false,"Reverse curl",R.drawable.reverse_curl))
//        arrlis.add(ExerciseNameModel(false,false,"Cross-body curl",R.drawable.cross_body_curl))
//        arrlis.add(ExerciseNameModel(false,false,"Backpack curl",R.drawable.backpack_curl))
//        arrlis.add(ExerciseNameModel(false, false,"Shoulder tap biceps curl",R.drawable.sholder_tap_biceps))
//        return arrlis
//    }
//    fun getExerciseTriceps():ArrayList<ExerciseNameModel>
//    {
//        var arrlis=ArrayList<ExerciseNameModel>()
//
//        arrlis.add(ExerciseNameModel(false,false,"Diamond push-up",R.drawable.diamond_pushup))
//        arrlis.add(ExerciseNameModel(false,false,"Bodyweight triceps extension",R.drawable.body_wt_tricep))
//        arrlis.add(ExerciseNameModel(false,false,"High-low plank",R.drawable.high_low_plank))
//        arrlis.add(ExerciseNameModel(false,false,"Bench triceps dip",R.drawable.bench_tricep))
//        arrlis.add(ExerciseNameModel(false,false,"Triceps kickback",R.drawable.triceps_kickback))
//        arrlis.add(ExerciseNameModel(false,false,"Overhead triceps extension",R.drawable.overhead_triceps))
//        arrlis.add(ExerciseNameModel(false,false,"Dumbbell floor press",R.drawable.dumble_floor_press))
//        arrlis.add(ExerciseNameModel(false, false,"Close-grip dumbbell press\n",R.drawable.crossgrip_triceps))
//        return arrlis
//    }
}