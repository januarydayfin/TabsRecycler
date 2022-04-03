package com.krayapp.tabsrecycler

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.tabsrecycler.databinding.ActivityMainBinding
import com.krayapp.tabsrecycler.view.screens.MainScreen
import com.krayapp.tabsrecycler.view.screens.SecondScreen
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)
    private val router: Router by inject()
    private val navigationHolder: NavigatorHolder by inject()
    private val viewBinding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: router.newRootScreen(MainScreen)
        bottomMenuInit()
    }


    private fun bottomMenuInit() {
        viewBinding.bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first_page -> {
                    router.navigateTo(MainScreen)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.second_page -> {
                    router.navigateTo(SecondScreen)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    override fun onResumeFragments() {
        navigationHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

}