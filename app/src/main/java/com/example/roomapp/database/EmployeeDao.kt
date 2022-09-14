package com.example.roomapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee_table")
    fun getAll() : LiveData<List<Employee>>

    @Query("SELECT * FROM employee_table WHERE id=:id")
    fun getEmployeeById(id: Int) : LiveData<Employee>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Update
    fun update(employee: Employee)
}