package com.krayapp.tabsrecycler.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.tabsrecycler.R
import com.krayapp.tabsrecycler.databinding.MainFragmentBinding
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import com.krayapp.tabsrecycler.view.adapter.AdapterDelegate
import com.krayapp.tabsrecycler.view.adapter.HomeworkAdapter
import com.krayapp.tabsrecycler.view.adapter.LessonAdapter
import com.krayapp.tabsrecycler.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment), AdapterDelegate {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewBinding: MainFragmentBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    private var homeworkAdapter = HomeworkAdapter(this)
    private var viewPagerAdapter = LessonAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.homeworkRecycler.adapter = homeworkAdapter
        viewBinding.viewPager.adapter = viewPagerAdapter
        observeTimer()
        getHomework()
        getLessons()
    }

    private fun renderTimer(array: IntArray) {
        viewBinding.timer.days.text = array[0].toString()
        viewBinding.timer.hours.text = array[1].toString()
        viewBinding.timer.minute.text = array[2].toString()
        viewBinding.timer.seconds.text = array[3].toString()
    }

    private fun observeTimer() {
        viewModel.timerLiveData.observe(viewLifecycleOwner) { renderTimer(it) }
        viewModel.getTimer()
    }

    private fun getLessons() {
        viewModel.lessonLiveData.observe(viewLifecycleOwner) {
            renderLessonList(it)
        }
        viewModel.getLessons()
    }

    private fun getHomework() {
        viewModel.homeworkLiveData.observe(viewLifecycleOwner) {
            renderHomeworkList(it)
        }
        viewModel.getHomework()
    }


    private fun renderLessonList(list: List<Lesson>) {
        viewPagerAdapter.submitList(list)
    }

    private fun renderHomeworkList(list: List<Homework>) {
        homeworkAdapter.submitList(list)
    }

    override fun onPickHomework(homework: Homework) {
        Toast.makeText(context, homework.homework, Toast.LENGTH_SHORT).show()
    }

    override fun onPickLesson(lesson: Lesson) {
        Toast.makeText(context, lesson.lessonName, Toast.LENGTH_SHORT).show()
    }


}
