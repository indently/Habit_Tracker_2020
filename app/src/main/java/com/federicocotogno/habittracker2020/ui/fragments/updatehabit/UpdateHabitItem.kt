package com.federicocotogno.habittracker2020.ui.fragments.updatehabit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.federicocotogno.habittracker2020.R
import com.federicocotogno.habittracker2020.ui.viewmodels.HabitViewModel
import kotlinx.android.synthetic.main.fragment_update_habit_item.*

class UpdateHabitItem : Fragment(R.layout.fragment_update_habit_item) {

    private val args by navArgs<UpdateHabitItemArgs>()
    private lateinit var habitViewModel: HabitViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        habitViewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        et_habitTitle_update.setText(args.selectedHabit.habit_title)
        et_habitDescription_update.setText(args.selectedHabit.habit_description)



    }

}