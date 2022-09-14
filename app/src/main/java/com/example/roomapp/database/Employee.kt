package com.example.roomapp.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val salary: Int
) : Parcelable
