package com.example.studentbudget.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "Budget")
 data class Budget (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val enterName: String,
    @ColumnInfo(name = "income")
    val enterBudget: Int,
    @ColumnInfo(name = "year")
    val enterYear : Double,
    @ColumnInfo(name = "accommodation")
    val enterAccommodation : Int,
    @ColumnInfo(name = "school_utilities")
    val enterSchool_Utilities : Int,
    @ColumnInfo(name = "transport")
    val enterTransport : Int,
    @ColumnInfo(name = "food")
    val enterFood : Int,
    @ColumnInfo(name = "entertainment")
    val enterEntertainment : Int,
    @ColumnInfo(name = "personal_utilities")
    val enterPersonal_Utilities : Int,
    @ColumnInfo(name = "total_expenses")
    val budgetTotal_Expenses : Int,
    @ColumnInfo(name = "total_deductible")
    val budgetTotal_Deductible : Int,
    @ColumnInfo(name = "budget")
    val enteringBudget : Int



)