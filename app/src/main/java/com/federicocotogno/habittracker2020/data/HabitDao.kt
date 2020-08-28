package com.federicocotogno.habittracker2020.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query("SELECT * FROM habit_table ORDER BY habit_startTime DESC")
    suspend fun getAllHabits(): LiveData<List<Habit>>

    @Query("DELETE FROM habit_table")
    suspend fun deleteAll()
}