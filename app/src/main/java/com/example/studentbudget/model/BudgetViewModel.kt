package com.example.studentbudget.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.studentbudget.data.Budget
import com.example.studentbudget.data.BudgetDao
import kotlinx.coroutines.launch

class BudgetViewModel(private val budgetDao: BudgetDao) : ViewModel() {

    private fun insertHere(budget: Budget) {
        viewModelScope.launch {
            budgetDao.insert(budget)
        }
    }

    private fun getNewBudgetEntry(
        enterName: String,
        enterBudget: String,
        enterYear: String,
        enterAccommodation: String,
        enterSchool_Utilities: String,
        enterFood: String,
        enterTransport: String,
        enterEntertainment: String,
        enterPersonal: String,
        budgetTotal_Expenses: String,
        budgetTotal_Deductible: String,
        enteringBudget: String
    ): Budget {
        return Budget(
            enterName = enterName,
            enterBudget = enterBudget.toInt(),
            enterYear = enterYear.toDouble(),
            enterAccommodation = enterAccommodation.toInt(),
            enterSchool_Utilities = enterSchool_Utilities.toInt(),
            enterFood = enterFood.toInt(),
            enterTransport = enterTransport.toInt(),
            enterEntertainment = enterEntertainment.toInt(),
            enterPersonal_Utilities = enterPersonal.toInt(),
            budgetTotal_Expenses = budgetTotal_Expenses.toInt(),
            budgetTotal_Deductible = budgetTotal_Deductible.toInt(),
            enteringBudget = enteringBudget.toInt()
        )
    }

    fun addNewBudget(
        enterName: String, enterBudget: String, enterYear: String,
        enterAccommodation: String, enterSchool_Utilities: String, enterFood: String,
        enterTransport: String, enterEntertainment: String, enterPersonal: String,
        budgetTotal_Expenses: String, budgetTotal_Deductible: String, enteringBudget: String
    ) {
        val newBudget = getNewBudgetEntry(
            enterName,
            enterBudget,
            enterYear,
            enterAccommodation,
            enterSchool_Utilities,
            enterFood,
            enterTransport,
            enterEntertainment,
            enterPersonal,
            budgetTotal_Expenses,
            budgetTotal_Deductible,
            enteringBudget
        )
        insertHere(newBudget)
    }

    fun isEntryValid(
        enterName: String, enterBudget: String, enterYear: String,
        enterAccommodation: String, enterSchool_Utilities: String, enterFood: String,
        enterTransport: String, enterEntertainment: String, enterPersonal: String,
        budgetTotal_Expenses: String, budgetTotal_Deductible: String, enteringBudget: String
    ): Boolean {
        if (enterName.isBlank() || enterBudget.isBlank() || enterYear.isBlank()
            || enterAccommodation.isBlank() || enterSchool_Utilities.isBlank() || enterFood.isBlank() ||
            enterTransport.isBlank() || enterEntertainment.isBlank() || enterPersonal.isBlank() ||
            budgetTotal_Expenses.isBlank() || budgetTotal_Deductible.isBlank() || enteringBudget.isBlank()
        ) {
            return false
        }
        return true
    }


}

class BudgetViewModelFactory(private val budgetDao: BudgetDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BudgetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BudgetViewModel(budgetDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}