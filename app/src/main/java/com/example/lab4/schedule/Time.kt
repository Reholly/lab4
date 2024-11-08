package com.example.lab4.schedule

import com.example.lab4.model.Lesson
import com.example.lab4.model.WeekDay
import java.time.LocalDate
import java.util.Calendar

object TimeUtils {
    private val firstWeek = mapOf<WeekDayItem, List<Item>>(
            Pair(
                WeekDayItem(WeekDay.MONDAY), listOf(
                    Lesson(
                        "БД лекция",
                        "18:20 - 19:50",
                        "А-13"
                    ),
                    Lesson(
                        "БД практика",
                        "19:55 - 21:25",
                        "А-13",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.TUESDAY), listOf(
                    Lesson(
                        "Управление ЖЦ ПО лекция",
                        "18:20 - 19:50",
                        "А-21"
                    ),
                    Lesson(
                        "Управление ЖЦ ПО практика",
                        "19:55 - 21:25",
                        "А-21",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.WEDNESDAY), listOf()
            ),
            Pair(
                WeekDayItem(WeekDay.THURSDAY), listOf(
                    Lesson(
                        "Фронтенд лекция",
                        "19:30 - 20:30",
                        "Дистант",
                    ),
                    Lesson(
                        "Фронтенд практика",
                        "20:30-21:25",
                        "Дистант",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.FRIDAY), listOf(
                    Lesson(
                        "Экономика практика",
                        "13:15 - 14:45",
                        "212",
                    ),
                    Lesson(
                        "Экономика лекция",
                        "15:00 - 16:30",
                        "221",
                    ),
                    Lesson(
                        "Экономика практика",
                        "16:40 - 18:10",
                        "221",
                    ),
                )
            ), Pair(
                WeekDayItem(WeekDay.SATURDAY), listOf(
                    Lesson(
                        "Тестирование",
                        "11:20 - 12:50",
                        "132",
                    ),
                    Lesson(
                        "Тестирование",
                        "13:15 - 14:45",
                        "132",
                    ),
                    Lesson(
                        "Android",
                        "15:00 - 16:30",
                        "326",
                    ),
                    Lesson(
                        "Android",
                        "16:40 - 18:10",
                        "326",
                    ),
                )
            )
        )
    private val secondWeek = mapOf<WeekDayItem, List<Item>>(
            Pair(
                WeekDayItem(WeekDay.MONDAY), listOf(
                    Lesson(
                        "Анализ данных лекция",
                        "16:40 - 18:10",
                        "А-13"
                    ),
                    Lesson(
                        "БД лекция",
                        "18:20 - 19:50",
                        "А-13",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.TUESDAY), listOf(
                    Lesson(
                        "Управление ЖЦ ПО лекция",
                        "18:20 - 19:50",
                        "А-21"
                    ),
                    Lesson(
                        "Управление ЖЦ ПО практика",
                        "19:55 - 21:25",
                        "А-21",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.WEDNESDAY), listOf(
                    Lesson(
                        "БД практика",
                        "18:20 - 19:50",
                        "А-21"
                    ),
                    Lesson(
                        "БД практика",
                        "19:55 - 21:25",
                        "А-21",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.THURSDAY), listOf(
                    Lesson(
                        "Фронтенд лекция",
                        "19:30 - 20:30",
                        "Дистант",
                    ),
                    Lesson(
                        "Фронтенд практика",
                        "20:30-21:25",
                        "Дистант",
                    ),
                )
            ),
            Pair(
                WeekDayItem(WeekDay.FRIDAY), listOf(
                    Lesson(
                        "Анализ данных практика",
                        "15:00 - 16:30",
                        "132",
                    ),
                    Lesson(
                        "Анализ данных практика",
                        "16:40 - 18:10",
                        "132",
                    ),
                )
            ), Pair(
                WeekDayItem(WeekDay.SATURDAY), listOf(
                    Lesson(
                        "Тестирование",
                        "11:20 - 12:50",
                        "132",
                    ),
                    Lesson(
                        "Тестирование",
                        "13:15 - 14:45",
                        "132",
                    ),
                    Lesson(
                        "Android",
                        "15:00 - 16:30",
                        "326",
                    ),
                    Lesson(
                        "Android",
                        "16:40 - 18:10",
                        "326",
                    ),
                )
            )
        )


    public fun currentWeekSchedule(): List<Item> =
        currentWeekFetchedSchedule().flatMap {
            scheduleEntry -> getItemListFromPair(scheduleEntry.toPair())
        }

    public fun currentDaySchedule(): List<Item> =
        getItemListFromPair(currentWeekFetchedSchedule().entries.find {
            it.key.current.ordinal == LocalDate.now().dayOfWeek.ordinal
        }?.toPair() ?: Pair(WeekDayItem(WeekDay.SUNDAY), emptyList()))


    private fun getItemListFromPair(entry: Pair<WeekDayItem, List<Item>>): List<Item> =
        mutableListOf<Item>().apply {
            add(entry.first) // Добавляем день
            if (entry.second.isEmpty()) {
                // Если нет уроков, добавляем сообщение о выходном
                add(Lesson("Выходной", "что ты здесь забыл", "дружок пирожок?"))
            } else {
                addAll(entry.second) // Добавляем пары
            }
        }


    private fun currentWeekFetchedSchedule(): Map<WeekDayItem, List<Item>> =
        if (Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) % 2 == 0) firstWeek
        else secondWeek
}