package com.example.tvseriesquiz

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import moxy.MvpAppCompatActivity
import javax.inject.Inject

open class BaseActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setupStatusBar()
    }

    protected open fun setupStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            val window = this.window
            val wic = WindowInsetsControllerCompat(window, window.decorView)
            wic.isAppearanceLightStatusBars = true
            window.statusBarColor = ContextCompat.getColor(this, R.color.purple_200)
        }
    }
}