package com.example.roomapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.roomapp.databinding.FragmentEmployeeListBinding


class EmployeeListFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_employee_list, container, false
        )
        return binding.root
    }
}