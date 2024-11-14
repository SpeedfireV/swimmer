package com.example.swimmer.data.models

data class DistanceMeasure(val riverName: String, val totalDistance: Int, val distanceSwimmed: Int) {
    val swimPercent: Float
        get() = 100 * distanceSwimmed.toFloat() / totalDistance.toFloat()
}