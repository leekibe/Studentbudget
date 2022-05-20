package com.example.studentbudget

import android.app.Application
import com.example.studentbudget.data.BudgetRoomDatabase

class BudgetApplication : Application() {

    val database: BudgetRoomDatabase by lazy { BudgetRoomDatabase.getDatabase(this) }

}
