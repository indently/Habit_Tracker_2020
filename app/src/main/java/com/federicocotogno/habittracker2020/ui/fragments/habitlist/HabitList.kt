package com.federicocotogno.habittracker2020.ui.fragments.habitlist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.federicocotogno.habittracker2020.R
import com.federicocotogno.habittracker2020.data.models.Habit
import com.federicocotogno.habittracker2020.ui.fragments.habitlist.adapters.HabitListAdapter
import com.federicocotogno.habittracker2020.ui.viewmodels.HabitViewModel
import kotlinx.android.synthetic.main.fragment_habit_list.*

class HabitList : Fragment(R.layout.fragment_habit_list) {

    private lateinit var habitList: List<Habit>
    private lateinit var habitViewModel: HabitViewModel
    private lateinit var adapter: HabitListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HabitListAdapter()
        rv_habits.adapter = adapter
        rv_habits.layoutManager = LinearLayoutManager(context)

        //Instantiate and create viewmodel observers
        viewModels()

        fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_habitList_to_createHabitItem)
        }

        //Show the options menu in this fragment
        setHasOptionsMenu(true)

        swipeToRefresh.setOnRefreshListener {
            adapter.setData(habitList)
            swipeToRefresh.isRefreshing = false
        }
    }

    private fun viewModels() {
        habitViewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        habitViewModel.getAllHabits.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            habitList = it

            if (it.isEmpty()) {
                rv_habits.visibility = View.GONE
                tv_emptyView.visibility = View.VISIBLE
            } else {
                rv_habits.visibility = View.VISIBLE
                tv_emptyView.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_delete -> habitViewModel.deleteAllHabits()
        }
        return super.onOptionsItemSelected(item)
    }

}