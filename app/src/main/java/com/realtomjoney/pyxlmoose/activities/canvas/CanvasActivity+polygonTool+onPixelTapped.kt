package com.realtomjoney.pyxlmoose.activities.canvas

import com.realtomjoney.pyxlmoose.algorithms.AlgorithmInfoParameter
import com.realtomjoney.pyxlmoose.algorithms.LineAlgorithm
import com.realtomjoney.pyxlmoose.models.BitmapAction
import com.realtomjoney.pyxlmoose.models.Coordinates
import com.realtomjoney.pyxlmoose.utility.Flags

fun CanvasActivity.polygonToolOnPixelTapped(coordinatesTapped: Coordinates) {
    Flags.DISABLE_ACTION_MOVE = true

    val lineAlgorithmInstance = LineAlgorithm(
        AlgorithmInfoParameter(
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap,
            BitmapAction(mutableListOf()),
            getSelectedColor()
        )
    )

    polygonCoordinates.add(coordinatesTapped)

    if (polygonCoordinates.size > 1) {
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.undo()

        for (i in 0 until polygonCoordinates.size - 2) {
            lineAlgorithmInstance.compute(
                polygonCoordinates[cindx - (i + 1)],
                polygonCoordinates[cindx - i]
            )
        }

        lineAlgorithmInstance.compute(polygonCoordinates[cindx], polygonCoordinates[cindx + 1])
        lineAlgorithmInstance.compute(polygonCoordinates[0], polygonCoordinates[cindx + 1])

        cindx += 1
    }
}