package com.example.swimmer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.swimmer.data.models.DistanceMeasure

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Goals.route,
) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Goals.route) {
            GoalsPage(goals = listOf(DistanceMeasure(riverName = "Vistula", totalDistance = 1000, distanceSwimmed = 500)))
        }
        composable (NavigationItem.Rivers.route) {
            RiversPage()
        }

    }

}