package com.krayapp.tabsrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.tabsrecycler.view.screens.MainScreen
import com.krayapp.tabsrecycler.view.screens.SecondScreen

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)
    private val router: Router by inject()
    private val navigationHolder: NavigatorHolder by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainScreen)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.first_page -> router.navigateTo(MainScreen)
            R.id.second_page -> router.navigateTo(SecondScreen)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResumeFragments() {
        navigationHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

}