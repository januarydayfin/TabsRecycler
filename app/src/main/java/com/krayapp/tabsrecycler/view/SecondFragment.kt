package com.krayapp.tabsrecycler.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.tabsrecycler.R
import com.krayapp.tabsrecycler.databinding.SecondFragmentBinding
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import com.krayapp.tabsrecycler.view.adapter.AdapterDelegate
import com.krayapp.tabsrecycler.view.adapter.SecondLessonAdapter
import com.krayapp.tabsrecycler.viewmodel.MainViewModel
import com.krayapp.tabsrecycler.viewmodel.SecondViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment:Fragment(R.layout.second_fragment), AdapterDelegate {
    companion object {
        fun newInstance() = SecondFragment()
    }
    private val viewBinding:SecondFragmentBinding by viewBinding()
    private val viewModel: SecondViewModel by viewModel()
    private var lessonsAdapter = SecondLessonAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.classesRecycler.adapter = lessonsAdapter
        getLessons()
    }

    override fun onPickHomework(homework: Homework) {
        Toast.makeText(context, homework.homework, Toast.LENGTH_SHORT).show()
    }

    override fun onPickLesson(lesson: Lesson) {
        Toast.makeText(context, lesson.lessonName, Toast.LENGTH_SHORT).show()
    }

    override fun skypeBtn() {
        val intent = activity?.packageManager?.getLaunchIntentForPackage("com.skype.raider")
        if (intent != null){
            startActivity(intent)
        }
    }

    private fun getLessons(){
        viewModel.lessonLiveData.observe(viewLifecycleOwner){
            renderLessonList(it)
        }
        viewModel.getLessons()
    }
    private fun renderLessonList(list:List<Lesson>){
        lessonsAdapter.submitList(list)
    }

}