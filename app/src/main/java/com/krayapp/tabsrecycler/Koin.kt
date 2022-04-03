package com.krayapp.tabsrecycler

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.tabsrecycler.data.IMainRepo
import com.krayapp.tabsrecycler.data.MainRepo
import com.krayapp.tabsrecycler.viewmodel.MainViewModel
import com.krayapp.tabsrecycler.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    private val cicerone = Cicerone.create()
    fun getModule() = module {
        //Cicerone
        single<Router> { cicerone.router }
        single<NavigatorHolder> { cicerone.getNavigatorHolder() }

        single<IMainRepo>{MainRepo()}

        viewModel { MainViewModel(repository = get()) }
        viewModel { SecondViewModel(repository = get()) }
    }

}