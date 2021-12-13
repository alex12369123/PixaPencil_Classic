package com.realtomjoney.pyxlmoose.activities.main

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.textfield.TextInputEditText
import com.realtomjoney.pyxlmoose.activities.canvas.CanvasActivity
import com.realtomjoney.pyxlmoose.utility.StringConstants

fun MainActivity.extendedOnDoneButtonPressed(spanCount: Int, titleEditText: TextInputEditText) {
    startActivity(
        Intent(this, CanvasActivity::class.java)
            .putExtra("SPAN_COUNT", Integer.parseInt(spanCount.toString()))
            .putExtra("PROJECT_TITLE", titleEditText.text.toString())
    )

    with(supportFragmentManager.beginTransaction()) {
        remove(newCanvasFragmentInstance)
        commit()
        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
    }

    with(binding) {
        activityMainPrimaryFragmentHost.visibility = View.GONE
        activityMainBottomNavigationView.visibility = View.VISIBLE
    }

    title = StringConstants.APP_NAME
    currentFragmentInstance = null
}