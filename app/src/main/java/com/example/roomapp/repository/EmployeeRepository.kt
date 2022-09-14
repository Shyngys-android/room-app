package com.example.roomapp.repository

import android.content.Context
import com.example.roomapp.database.Employee
import com.example.roomapp.database.EmployeeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class EmployeeRepository {

    companion object {
        var employeeDatabase: EmployeeDatabase? = null
        var employee: Employee? = null

        fun initializeDb(context: Context): EmployeeDatabase {
            return EmployeeDatabase.getInstance(context)!!
        }

        fun insertEmployee(context: Context, employee: Employee) {
            employeeDatabase = initializeDb(context)

            CoroutineScope(IO).launch {
                employeeDatabase!!.getEmployeeDao().insert(employee)
            }
        }
    }
}