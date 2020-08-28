 package com.federicocotogno.habittracker2020.ui.fragments.createhabit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.federicocotogno.habittracker2020.R
import kotlinx.android.synthetic.main.fragment_create_habit_item.*

 class CreateHabitItem : Fragment(R.layout.fragment_create_habit_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        imageSelected()
    }

    private fun imageSelected(){

        iv_fastFoodSelected.setOnClickListener{
            iv_fastFoodSelected.isSelected = !iv_fastFoodSelected.isSelected

        }

        iv_smokingSelected.setOnClickListener{
            iv_smokingSelected.isSelected = !iv_smokingSelected.isSelected

        }

        iv_teaSelected.setOnClickListener{
            iv_teaSelected.isSelected = !iv_teaSelected.isSelected

        }

    }

}