package com.example.lab4.schedule

import com.example.lab4.model.WeekDay

interface Item

data class WeekDayItem(val current: WeekDay): Item {
    override fun equals(other: Any?): Boolean {
        return other is WeekDayItem && this.current == other.current
    }
    override fun hashCode(): Int {
        return current.hashCode()
    }
}

enum class ViewType { Lesson, DayItem }

