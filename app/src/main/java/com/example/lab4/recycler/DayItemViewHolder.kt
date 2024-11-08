package com.example.lab4.recycler

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.DayBinding
import com.example.lab4.schedule.WeekDayItem

public class DayItemViewHolder(private val context: Context, private val binding: DayBinding) : RecyclerView.ViewHolder(binding.root) {
    public fun set(dayTitleItem: WeekDayItem) {
        binding.dayTitle.text = context.getText(dayTitleItem.current.ord)
    }
}