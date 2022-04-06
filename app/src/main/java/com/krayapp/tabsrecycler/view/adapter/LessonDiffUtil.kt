package com.krayapp.tabsrecycler.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson

object LessonDiffUtil: DiffUtil.ItemCallback<Lesson>() {
    private val payload = Any()

    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return (oldItem.lessonName == newItem.lessonName && oldItem.time == newItem.time)
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return (oldItem.lessonName == newItem.lessonName && oldItem.time == newItem.time)
    }

    override fun getChangePayload(oldItem: Lesson, newItem: Lesson): Any = payload
}