package com.example.swimmer

enum class Screen {
    GOALS,
    RIVERS,
    ADD_GOAL,
    RIVER_INFO
}

sealed class Screens(val route: String) {
    data object Goals: Screens(Screen.GOALS.name)
    data object Rivers: Screens(Screen.RIVERS.name)
    data object AddGoal: Screens(Screen.ADD_GOAL.name + "/")
    data object RiverInfo: Screens(Screen.RIVER_INFO.name)
}

