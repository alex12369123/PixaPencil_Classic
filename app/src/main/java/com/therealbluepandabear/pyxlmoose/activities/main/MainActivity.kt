package com.therealbluepandabear.pyxlmoose.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.therealbluepandabear.pyxlmoose.fragments.newcanvas.NewCanvasFragment
import com.therealbluepandabear.pyxlmoose.listeners.NewCanvasFragmentListener
import com.therealbluepandabear.pyxlmoose.listeners.RecentCreationsListener
import com.therealbluepandabear.pyxlmoose.models.PixelArt


class MainActivity : AppCompatActivity(), RecentCreationsListener, NewCanvasFragmentListener {
    val context = this

    lateinit var newCanvasFragmentInstance: NewCanvasFragment

    var currentFragmentInstance: Fragment? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extendedOnCreate()
    }

    override fun onResume() {
        extendedOnResume()
        super.onResume()
    }

    override fun onCreationTapped(creationTapped: PixelArt) = extendedOnCreationTapped(creationTapped)

    override fun onCreationLongTapped(creationTapped: PixelArt) = extendedOnCreationLongTapped(creationTapped)

    override fun onBackPressed() {
        if (currentFragmentInstance != null) extendedOnBackPressed() else super.onBackPressed()
    }

    override fun onDoneButtonPressed(projectName: String, width: Int, height: Int) = extendedOnDoneButtonPressed(projectName, width, height)
}
