package com.example.swimmer

data class DistanceMeasure(val totalDistance: Int, val distanceSwimmed: Int) {
    val swimPercent: Float
        get() = 100 * distanceSwimmed.toFloat() / totalDistance.toFloat()
}