package com.krayapp.tabsrecycler

import com.krayapp.tabsrecycler.data.IMainRepo
import com.krayapp.tabsrecycler.data.MainRepo
import com.krayapp.tabsrecycler.viewmodel.MainViewModel
import com.krayapp.tabsrecycler.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    fun getModule() = module {

        single<IMainRepo>{MainRepo()}

        viewModel { MainViewModel(repository = get()) }
        viewModel { SecondViewModel(repository = get()) }
    }

}