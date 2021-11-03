package com.realtomjoney.pyxlmoose.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.realtomjoney.pyxlmoose.databinding.ActivityMainBinding
import com.realtomjoney.pyxlmoose.listeners.RecentCreationsListener
import com.realtomjoney.pyxlmoose.models.PixelArt

class MainActivity : AppCompatActivity(), RecentCreationsListener {

    lateinit var binding: ActivityMainBinding
    var hasNavigatedBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()
        setOnClickListeners()
        setTitle()
    }

    private fun setTitle() {
        title = "Home"
    }

    private fun setOnClickListeners() = extendedSetOnClickListeners()

    override fun onResume() {
        extendedOnResume()
        super.onResume()
    }

    private fun setBindings() = extendedSetBindings()

    override fun onCreationTapped(param: PixelArt) = extendedOnCreationTapped(param)

    fun refreshAdapter() = extendedRefreshAdapter()

    override fun onCreationLongTapped(param: PixelArt) = extendedOnCreationLongTapped(param)
}
