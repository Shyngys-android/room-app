package com.example.roomapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.roomapp.database.Employee
import com.example.roomapp.repository.EmployeeRepository

class EmployeeListViewModel(
    app: Application
) : AndroidViewModel(app) {

    private val refresh = MutableLiveData<Unit>()

    init {
        refresh.value = Unit
    }

    val employeeListLiveData: LiveData<List<Employee>> =
        Transformations.switchMap(refresh) {
            EmployeeRepository.getEmployeeList(app.baseContext)
        }
}