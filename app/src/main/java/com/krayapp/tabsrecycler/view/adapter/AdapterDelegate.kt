package com.krayapp.tabsrecycler.view.adapter

import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson

interface AdapterDelegate {
    fun onPickHomework(homework: Homework)
    fun onPickLesson(lesson: Lesson)
    fun skypeBtn()
}
