package com.krayapp.tabsrecycler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.tabsrecycler.data.IMainRepo
import com.krayapp.tabsrecycler.entity.Lesson
import kotlinx.coroutines.*

class SecondViewModel(private val repository:IMainRepo):ViewModel() {

    private val _lessonLiveData = MutableLiveData<List<Lesson>>()
    val lessonLiveData: LiveData<List<Lesson>>
        get() = _lessonLiveData

    private val dataScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var dataJob: Job? = null

    fun getLessons() {
        dataJob?.cancel()
        dataJob = dataScope.launch {
            _lessonLiveData.postValue(getLessonsFromRepo())
        }
    }
    private fun getLessonsFromRepo(): List<Lesson> = repository.getLessonList().toList()

}