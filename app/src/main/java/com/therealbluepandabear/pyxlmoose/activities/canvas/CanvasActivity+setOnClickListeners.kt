package com.therealbluepandabear.pyxlmoose.activities.canvas

import android.graphics.drawable.ColorDrawable
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.therealbluepandabear.pyxlmoose.R
import com.therealbluepandabear.pyxlmoose.extensions.navigateTo
import com.therealbluepandabear.pyxlmoose.fragments.brushes.BrushesFragment
import com.therealbluepandabear.pyxlmoose.fragments.colorpalettes.ColorPalettesFragment
import com.therealbluepandabear.pyxlmoose.fragments.filters.FiltersFragment
import com.therealbluepandabear.pyxlmoose.fragments.tools.ToolsFragment
import com.therealbluepandabear.pyxlmoose.utility.StringConstants


fun CanvasActivity.openColorPickerDialog(colorPaletteMode: Boolean = false) {
    colorPickerFragmentInstance = initColorPickerFragmentInstance(colorPaletteMode)
    currentFragmentInstance = colorPickerFragmentInstance
    navigateTo(supportFragmentManager, colorPickerFragmentInstance, R.id.activityCanvas_primaryFragmentHost, StringConstants.FragmentColorPickerTitle, binding.activityCanvasPrimaryFragmentHost, binding.activityCanvasRootLayout)
}

fun clearCanvas() {
    outerCanvasInstance.canvasFragment.myCanvasViewInstance.clearCanvas()
}

fun CanvasActivity.setOnClickListeners() {
    brushesFragmentInstance = BrushesFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, brushesFragmentInstance!!).commit()

    filtersFragmentInstance = FiltersFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, filtersFragmentInstance!!).commit()

    colorPalettesFragmentInstance = ColorPalettesFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, colorPalettesFragmentInstance!!).commit()

    toolsFragmentInstance = ToolsFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, toolsFragmentInstance!!).commit()

    binding.activityCanvasTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            when (tab.position) {
                0 -> {
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    toolsFragmentInstance!!.requireView().visibility = View.VISIBLE
                }

                1 -> {
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.VISIBLE
                }

                2 -> {
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    colorPalettesFragmentInstance!!.requireView().visibility = View.VISIBLE
                }

                3 -> {
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) { }

        override fun onTabUnselected(tab: TabLayout.Tab) { }
    })

    binding.activityCanvasColorSecondaryView.setOnClickListener {
        isPrimaryColorSelected = false
        binding.activityCanvasColorPrimaryViewIndicator.visibility = View.INVISIBLE
        binding.activityCanvasColorSecondaryViewIndicator.visibility = View.VISIBLE
        setPixelColor((binding.activityCanvasColorSecondaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorPrimaryView.setOnLongClickListener {
        isPrimaryColorSelected = true
        openColorPickerDialog()
        hideMenuItems()
        true
    }


    binding.activityCanvasColorPrimaryView.setOnClickListener {
        isPrimaryColorSelected = true
        binding.activityCanvasColorSecondaryViewIndicator.visibility = View.INVISIBLE
        binding.activityCanvasColorPrimaryViewIndicator.visibility = View.VISIBLE
        setPixelColor((binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorSecondaryView.setOnLongClickListener {
        isPrimaryColorSelected = false
        openColorPickerDialog()
        hideMenuItems()
        true
    }
}