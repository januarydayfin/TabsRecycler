package com.krayapp.tabsrecycler.data

import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson

interface IMainRepo {
    fun getLessonList():MutableList<Lesson>
    fun getHomework():MutableList<Homework>
}