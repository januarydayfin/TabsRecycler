package com.krayapp.tabsrecycler.data

import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import java.util.*

class MainRepo : IMainRepo {
    private val lessonList: MutableList<Lesson> = mutableListOf(
        Lesson("Science", Date(2022, 4, 22, 13, 30), "Ivanov A.V"),
        Lesson("History", Date(2022, 4, 22, 12, 30),"Petrov V.B" ),
        Lesson("Math", Date(2022, 4, 22, 11, 30), "Skalkina A.U"),
        Lesson("Physics", Date(2022, 4, 22, 10, 30), "Medvedev A.U")
    )
    private val homeworkList:MutableList<Homework> = mutableListOf(
        Homework("Science", "Выучить таблицу элементов",1),
        Homework("History", "Все о Рюриковичах",2),
        Homework("Math", "2+2 = ?",3),
        Homework("Physics", "Первый закон Ома",4)
    )

    override fun getLessonList(): MutableList<Lesson> = lessonList

    override fun getHomework(): MutableList<Homework> = homeworkList


}