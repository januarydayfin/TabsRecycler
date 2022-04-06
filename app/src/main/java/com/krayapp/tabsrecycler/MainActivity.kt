package com.krayapp.tabsrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.tabsrecycler.databinding.ActivityMainBinding
import com.krayapp.tabsrecycler.view.MainFragment
import com.krayapp.tabsrecycler.view.SecondFragment

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)
    private val viewBinding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //savedInstanceState ?: router.newRootScreen(MainScreen)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,MainFragment.newInstance())
            .commitNow()
        bottomMenuInit()
    }


    private fun bottomMenuInit() {
        viewBinding.bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first_page -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,MainFragment.newInstance())
                        .commitNow()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.second_page -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,SecondFragment.newInstance())
                        .commitNow()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
}