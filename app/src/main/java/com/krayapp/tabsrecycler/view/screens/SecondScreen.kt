package com.krayapp.tabsrecycler.view.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.tabsrecycler.view.SecondFragment

object SecondScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        SecondFragment.newInstance()

}