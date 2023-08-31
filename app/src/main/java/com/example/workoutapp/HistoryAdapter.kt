package com.example.workoutapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.HistoryRecycleViewBinding

class HistoryAdapter(
    private val items: ArrayList<HistoryEntity>
) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HistoryRecycleViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.eno?.text=item.id.toString()
        holder.ename?.text=item.name
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(binding: HistoryRecycleViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var eno=binding?.ExerciseNo
        var ename=binding?.ExerciseName
    }
}