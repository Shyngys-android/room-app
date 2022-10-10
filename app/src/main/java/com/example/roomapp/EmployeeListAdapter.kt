package com.example.roomapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.database.Employee
import com.example.roomapp.databinding.AdapterEmployeeBinding

class EmployeeListAdapter(
    private val context: Context,
    private val list: List<Employee>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: AdapterEmployeeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        binding = AdapterEmployeeBinding.inflate(layoutInflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as MyViewHolder

        viewHolder.initContent(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private val binding: AdapterEmployeeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun initContent(employee: Employee) {
            binding.tvName.text = employee.name
            binding.tvSalary.text = employee.salary
        }
    }
}