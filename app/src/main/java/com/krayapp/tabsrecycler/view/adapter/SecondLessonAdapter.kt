package com.krayapp.tabsrecycler.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.tabsrecycler.R
import com.krayapp.tabsrecycler.databinding.LessonTemplateFirstBinding
import com.krayapp.tabsrecycler.databinding.LessonTemplateSecondBinding
import com.krayapp.tabsrecycler.entity.Lesson

class SecondLessonAdapter(private val adapterDelegate: AdapterDelegate?) :
    ListAdapter<Lesson, SecondLessonViewHolder>(LessonDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondLessonViewHolder =
        SecondLessonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.lesson_template_second, parent, false)
        )


    override fun onBindViewHolder(holder: SecondLessonViewHolder, position: Int) {
        holder.bind(getItem(position), adapterDelegate)
    }
}

class SecondLessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding: LessonTemplateSecondBinding by viewBinding()
    fun bind(lesson: Lesson, delegate: AdapterDelegate?) {
        with(viewBinding) {
            lessonName.text = lesson.lessonName
            time.text = lesson.time
            root.setOnClickListener{
                delegate?.onPickLesson(lesson)
            }
            skypeBtn.setOnClickListener{delegate?.skypeBtn()}
        }
    }
}