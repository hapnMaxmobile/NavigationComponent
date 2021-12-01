package com.example.navigationcomponent

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.navigationcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var controller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        controller = findNavController(R.id.my_nav_host_fragment)
//        mBinding.navigationView.setupWithNavController(controller)
        setSupportActionBar(mBinding.toolbar)
        mBinding.toolbar.setupWithNavController(controller)
        mBinding.btnOk.setOnClickListener {
            val activityNavigator = ActivityNavigator(this)
            activityNavigator.navigate(
                activityNavigator.createDestination().setIntent(
                    Intent(
                        this,
                        SecondActivity::class.java
                    )
                ), null, null, null
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(controller) || super.onOptionsItemSelected(item)
    }
}