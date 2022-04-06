package com.krayapp.tabsrecycler.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.tabsrecycler.R
import com.krayapp.tabsrecycler.databinding.HomeworkTemplateBinding
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson

class HomeworkAdapter(private val adapterDelegate: AdapterDelegate?) :
    ListAdapter<Homework, HomeworkViewHolder>(HomeworkDiffUtil) {
    interface AdapterDelegate {
        fun onPick(homework: Homework)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder =
        HomeworkViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.homework_template, parent, false)
        )


    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(getItem(position), adapterDelegate )
    }
}

class HomeworkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding: HomeworkTemplateBinding by viewBinding()

    fun bind(homework: Homework, delegate:HomeworkAdapter.AdapterDelegate?){
        with(viewBinding){
            lessonName.text = homework.lesson
            timeRemaining.text = homework.days.toString()
            homeworkView.text = homework.homework
        }
    }
}