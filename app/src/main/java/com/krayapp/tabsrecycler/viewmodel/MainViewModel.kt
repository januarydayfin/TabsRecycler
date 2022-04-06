package com.krayapp.tabsrecycler.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.tabsrecycler.data.IMainRepo
import com.krayapp.tabsrecycler.entity.Homework
import com.krayapp.tabsrecycler.entity.Lesson
import kotlinx.coroutines.*
import org.jetbrains.annotations.NotNull
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(private val repository: IMainRepo) : ViewModel() {
    private val EVENT_DATE_TIME = "2022-04-27 10:30:00"
    private val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

    private val _timerLiveData = MutableLiveData<IntArray>()
    val timerLiveData: LiveData<IntArray>
        get() = _timerLiveData

    private val _lessonLiveData = MutableLiveData<List<Lesson>>()
    val lessonLiveData: LiveData<List<Lesson>>
        get() = _lessonLiveData

    private val _homeworkLiveData = MutableLiveData<List<Homework>>()
    val homeworkLiveData: LiveData<List<Homework>>
        get() = _homeworkLiveData

    private val timerScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var timerJob: Job? = null

    private val dataScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var dataJob: Job? = null


    @SuppressLint("SimpleDateFormat")
    private fun calculateTimer() {
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        val event_date = dateFormat.parse(EVENT_DATE_TIME)
        var current_date = Date()
        timerJob = timerScope.launch {
            while (!current_date.after(event_date)) {
                current_date = Date()
                var diff = event_date.time - current_date.time
                var days = (diff / (24 * 60 * 60 * 1000)).toInt()
                var hours = (diff / (60 * 60 * 1000) % 24).toInt()
                var minutes = (diff / (60 * 1000) % 60).toInt()
                var seconds = (diff / 1000 % 60).toInt()
                _timerLiveData.postValue(intArrayOf(days, hours, minutes, seconds))
                delay(1000L)
            }
        }
    }

    fun getTimer() {
        calculateTimer()
    }

    fun getLessons() {
        dataJob?.cancel()
        dataJob = dataScope.launch {
            _lessonLiveData.postValue(getLessonsFromRepo())
        }
    }

    fun getHomework() {
        dataJob?.cancel()
        dataJob = dataScope.launch {
            _homeworkLiveData.postValue(getHomeworkFromRepo())
        }
    }

    private fun getLessonsFromRepo(): List<Lesson> = repository.getLessonList().toList()
    private fun getHomeworkFromRepo(): List<Homework> = repository.getHomework().toList()

}