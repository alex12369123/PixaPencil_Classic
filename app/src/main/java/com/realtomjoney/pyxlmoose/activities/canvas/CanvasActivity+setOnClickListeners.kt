package com.realtomjoney.pyxlmoose.activities.canvas

import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.realtomjoney.pyxlmoose.*
import com.realtomjoney.pyxlmoose.extensions.navigateTo
import com.realtomjoney.pyxlmoose.fragments.FiltersFragment
import com.realtomjoney.pyxlmoose.fragments.ToolsFragment
import com.realtomjoney.pyxlmoose.utility.StringConstants

private fun CanvasActivity.openColorPickerDialog() {
    colorPickerFragmentInstance = initColorPickerFragmentInstance()
    currentFragmentInstance = colorPickerFragmentInstance
    navigateTo(supportFragmentManager, colorPickerFragmentInstance, R.id.activityCanvas_primaryFragmentHost, StringConstants.FRAGMENT_COLOR_PICKER_TITLE, binding.activityCanvasPrimaryFragmentHost, binding.activityCanvasRootLayout)
}

fun clearCanvas() {
    val dataAsPixelList = canvasFragmentInstance.myCanvasViewInstance.saveData()

    for (pixel in dataAsPixelList) {
        pixel.pixelColor = null
    }

    canvasFragmentInstance.myCanvasViewInstance.drawFromPixelList(dataAsPixelList)
}

fun CanvasActivity.extendedSetOnClickListeners() {
    filtersFragmentInstance = FiltersFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, filtersFragmentInstance!!).commit()

    toolsFragmentInstance = ToolsFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, toolsFragmentInstance!!).commit()

    binding.activityCanvasTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            when (tab.text) {
                getString(R.string.tab_tools_str) -> {
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    toolsFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
                getString(R.string.tab_filters_str) -> {
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
                getString(R.string.tab_export_str) -> {
                }
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) { }

        override fun onTabUnselected(tab: TabLayout.Tab) { }
    })

    binding.activityCanvasColorSecondaryView.setOnClickListener {
        isPrimaryColorSelected = false
        setPixelColor((binding.activityCanvasColorSecondaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorPrimaryView.setOnLongClickListener {
        isPrimaryColorSelected = true
        openColorPickerDialog()
        true
    }


    binding.activityCanvasColorPrimaryView.setOnClickListener {
        isPrimaryColorSelected = true
        setPixelColor((binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorSecondaryView.setOnLongClickListener {
        isPrimaryColorSelected = false
        openColorPickerDialog()
        true
    }
}