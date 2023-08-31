package com.example.workoutapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ActivityChoicervBinding

class ExerciseChoiceAdapter(
    private val items: ArrayList<ExerciseChoiceModel>
) :
    RecyclerView.Adapter<ExerciseChoiceAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActivityChoicervBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.txt?.text = item.getexerciseName()
        holder.img?.setImageResource(item.getimage())
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, item )
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun setOnClickListener(onClickListener: ExerciseChoiceAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: ExerciseChoiceModel)
    }
    class ViewHolder(binding: ActivityChoicervBinding) : RecyclerView.ViewHolder(binding.root) {
        val img=binding?.ecapapteriv
        val txt=binding?.ecadaptertv
    }
}