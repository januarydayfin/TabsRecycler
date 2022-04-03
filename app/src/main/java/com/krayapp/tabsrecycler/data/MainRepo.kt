package com.krayapp.tabsrecycler.data

import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import java.util.*

class MainRepo : IMainRepo {
    private val lessonList: MutableList<Lesson> = mutableListOf(
        Lesson("Science", Date(2022, 4, 22, 13, 30)),
        Lesson("History", Date(2022, 4, 22, 12, 30)),
        Lesson("Math", Date(2022, 4, 22, 11, 30)),
        Lesson("Physics", Date(2022, 4, 22, 10, 30))
    )
    private val homeworkList:MutableList<Homework> = mutableListOf(
        Homework("Science", "Выучить таблицу элементов"),
        Homework("History", "Все о Рюриковичах"),
        Homework("Math", "2+2 = ?"),
        Homework("Physics", "Первый закон Ома")
    )

    override fun getLessonList(): MutableList<Lesson> = lessonList

    override fun getHomework(): MutableList<Homework> = homeworkList


}