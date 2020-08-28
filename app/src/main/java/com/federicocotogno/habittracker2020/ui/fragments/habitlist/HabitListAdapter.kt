package com.federicocotogno.habittracker2020.ui.fragments.habitlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.federicocotogno.habittracker2020.R
import com.federicocotogno.habittracker2020.data.models.Habit

class HabitListAdapter : RecyclerView.Adapter<HabitListAdapter.MyViewHolder>() {

    var habitsList = emptyList<Habit>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition

                val action = HabitListDirections.actionHabitListToUpdateHabitItem(habitsList[position])
                itemView.findNavController().navigate(action)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_habit_item, parent,false))
    }

    override fun onBindViewHolder(holder: HabitListAdapter.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}