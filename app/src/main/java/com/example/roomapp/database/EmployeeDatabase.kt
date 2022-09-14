package com.example.roomapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Employee::class
    ],
    version = 1
)

abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun getEmployeeDao(): EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null
        fun getInstance(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    "employee.db").build()
            }
            return INSTANCE
        }
    }
}