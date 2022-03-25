package com.therealbluepandabear.pyxlmoose.activities.canvas

import com.therealbluepandabear.pyxlmoose.R
import com.therealbluepandabear.pyxlmoose.extensions.disable
import java.math.RoundingMode

fun zoomOut() {
    outerCanvasInstance.cardViewParent.apply {
        val canZoomOut = outerCanvasInstance.cardViewParent.scaleX - zoomIncrement > zoomIncrement

        if (canZoomOut) {
            scaleX -= zoomIncrement
            scaleY -= zoomIncrement
        }

        if (scaleX - zoomIncrement < zoomIncrement.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()) {
            menu.findItem(R.id.zoom_out).disable()
        }
    }

    outerCanvasInstance.canvasFragment.myCanvasViewInstance.invalidate()
}