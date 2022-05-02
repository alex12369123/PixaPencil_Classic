package com.therealbluepandabear.pixapencil.canvasactivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CanvasActivityTopAppMenuTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(CanvasActivity::class.java)

    @Before
    fun setup() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().context)
    }

    @Test
    fun checkClearCanvasItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_clear_canvas_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFindAndReplaceItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_find_and_replace_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkNewColorPaletteItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_new_color_palette_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkGridItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_grid_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPixelPerfectItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_pixel_perfect_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkResetZoomItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_reset_zoom_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkSymmetryItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_symmetry_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkSaveToPNGItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_save_as_png_str)).check(matches(isDisplayed()))
    }

    @Test
    fun checkSaveToJPGItemIsDisplayed() {
        onView(withText(R.string.activityCanvasTopAppMenu_save_as_jpg_str)).check(matches(isDisplayed()))
    }
}