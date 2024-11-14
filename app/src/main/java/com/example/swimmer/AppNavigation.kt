package com.example.swimmer

enum class Screen {
    GOALS,
    RIVERS,
    ADD_GOAL
}

sealed class NavigationItem(val route: String) {
    data object Goals: NavigationItem(Screen.GOALS.name)
    data object Rivers: NavigationItem(Screen.RIVERS.name)
    data object AddGoal: NavigationItem(Screen.ADD_GOAL.name)
}

