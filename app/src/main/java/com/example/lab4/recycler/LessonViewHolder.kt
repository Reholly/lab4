package com.example.lab4.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.LessonBinding
import com.example.lab4.model.Lesson

class LessonViewHolder(private val binding: LessonBinding) : RecyclerView.ViewHolder(binding.root) {
    private val items = with(binding) {
        listOf(
            title,
            time,
            room,
        )
    }

    public fun set(item: Lesson) {
        with(binding) {
            time.text = item.time
            title.text = item.title
            room.text = item.room
        }
    }
}