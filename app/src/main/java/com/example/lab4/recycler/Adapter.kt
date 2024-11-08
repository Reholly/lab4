package com.example.lab4.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.DayBinding
import com.example.lab4.model.Lesson
import com.example.lab4.schedule.WeekDayItem
import com.example.lab4.schedule.Item
import com.example.lab4.databinding.LessonBinding
import com.example.lab4.schedule.ViewType

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = listOf<Item>()
    fun submitValue(list: List<Item>) {
        items = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) =
        when (items[position]) {
            is WeekDayItem -> ViewType.DayItem
            else -> ViewType.Lesson
        }.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.Lesson.ordinal -> LessonViewHolder(
                LessonBinding.inflate(layoutInflater, parent, false)
            )

            else -> DayItemViewHolder(
                parent.context, DayBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DayItemViewHolder ->
                holder.set(items[position] as WeekDayItem)
            is LessonViewHolder ->
                holder.set(items[position] as Lesson)
        }
    }
}