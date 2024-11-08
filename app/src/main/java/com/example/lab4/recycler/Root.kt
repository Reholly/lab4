package com.example.lab4.recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.R
import com.example.lab4.databinding.RootBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lab4.schedule.TimeUtils

class Root : Fragment(R.layout.root) {
    private val binding: RootBinding by viewBinding()
    private val scheduleAdapter = Adapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.navbar.setOnItemSelectedListener { selectedItem ->
            val schedule = if (selectedItem.itemId == R.id.today) {
                TimeUtils.currentDaySchedule()
            } else {
                TimeUtils.currentWeekSchedule()
            }
            scheduleAdapter.submitValue(schedule)
            true
        }

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = scheduleAdapter
        }

        scheduleAdapter.submitValue(TimeUtils.currentDaySchedule())
    }
}