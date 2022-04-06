package com.krayapp.tabsrecycler.data

import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import java.util.*

class MainRepo : IMainRepo {
    private val lessonList: MutableList<Lesson> = mutableListOf(
        Lesson("Science","9:00 - 9:30" , "Ivanov A.V"),
        Lesson("History","9:35 - 10:05","Petrov V.B" ),
        Lesson("Math","10:10 - 10:40 " ,"DatSkalkina A.U"),
        Lesson("Physics", "11:00 - 11:30", "Medvedev A.U")
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