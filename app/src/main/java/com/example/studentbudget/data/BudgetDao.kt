package com.example.studentbudget.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface BudgetDao {

    @Query("SELECT * from budget WHERE id = :id")
    fun getBudget(id: Int): Flow<Budget>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(budget: Budget)


    @Update
    suspend fun update(budget: Budget)

    @Delete
    suspend fun delete(budget: Budget)
}