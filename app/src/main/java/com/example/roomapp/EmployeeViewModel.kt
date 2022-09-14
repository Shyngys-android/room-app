package com.example.roomapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomapp.database.Employee
import com.example.roomapp.repository.EmployeeRepository

class EmployeeViewModel(
    val app: Application
) : AndroidViewModel(app) {

    val nameLiveData = MutableLiveData<String>()
    val salaryLiveData = MutableLiveData<String>()

    fun onAddClick() {
        EmployeeRepository.insertEmployee(app.applicationContext, Employee(
            name = nameLiveData.value?:"", salary = salaryLiveData.value?:""
        ))
    }
}