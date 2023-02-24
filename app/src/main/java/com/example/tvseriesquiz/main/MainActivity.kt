package com.example.tvseriesquiz.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.tvseriesquiz.BaseActivity
import com.example.tvseriesquiz.R
import com.example.tvseriesquiz.databinding.ActivityMainBinding

class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.toolbar)
        binding.toolbar.toolbar.title = getString(R.string.app_name)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_btn, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_settings) {
            navController.navigate(R.id.settingsFragment)
        } else if (item.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return true
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}