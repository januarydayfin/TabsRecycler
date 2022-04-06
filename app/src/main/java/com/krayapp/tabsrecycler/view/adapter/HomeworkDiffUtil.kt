package com.krayapp.tabsrecycler.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson

object HomeworkDiffUtil:DiffUtil.ItemCallback<Homework>() {
    private val payload = Any()

    override fun areItemsTheSame(oldItem: Homework, newItem: Homework): Boolean {
        return (oldItem.lesson == newItem.lesson && oldItem.homework == newItem.homework)
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Homework, newItem: Homework): Boolean {
        return (oldItem.lesson == newItem.lesson && oldItem.homework == newItem.homework)
    }

    override fun getChangePayload(oldItem: Homework, newItem: Homework): Any = payload
}