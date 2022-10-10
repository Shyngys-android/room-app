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

    val successLiveData = MutableLiveData<Unit>()
    val openFragment = MutableLiveData<Unit>()

    fun onAddClick() {
        EmployeeRepository.insertEmployee(
            app.applicationContext, Employee(
                name = nameLiveData.value ?: "", salary = salaryLiveData.value ?: ""
            )
        )
        successLiveData.value = Unit
    }

    fun onOpenFragmentList() {
        openFragment.value = Unit
    }
}