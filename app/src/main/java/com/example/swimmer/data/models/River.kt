package com.example.swimmer.data.models

import kotlinx.serialization.Serializable

@Serializable
data class River(val riverName: String = "Vistula", val totalDistance: Int = 0, val description: String = "Description", val countries: List<String> = listOf("Poland", "Germany")) { // TODO: Add Map Info

}
