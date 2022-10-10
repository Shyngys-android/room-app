package com.example.roomapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.databinding.FragmentEmployeeListBinding


class EmployeeListFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeListBinding
    private lateinit var viewModel: EmployeeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_employee_list, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this)[EmployeeListViewModel::class.java]

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.employeeListLiveData.observe(
            viewLifecycleOwner
        ) {
            val adapter = EmployeeListAdapter(requireContext(), it)

            binding.rvList.adapter = adapter
        }
    }


}