package com.example.swimmer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.swimmer.data.models.DistanceMeasure
import com.example.swimmer.data.models.River
import com.example.swimmer.pages.AddGoalPage
import com.example.swimmer.pages.GoalsPage
import com.example.swimmer.pages.RiverInfoPage
import com.example.swimmer.pages.RiversPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screens.Goals.route,
) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable(route=Screens.Goals.route) {

            GoalsPage(navController = navController, goals = listOf(DistanceMeasure(riverName = "Vistula", totalDistance = 1000, distanceSwimmed = 500)))
        }
        composable (route=Screens.Rivers.route) {
            RiversPage()
        }
        composable (route=Screens.RiverInfo.route) {
                backstackEntry -> val river: River = backstackEntry.toRoute()
            RiverInfoPage(river=river)
        }
        composable (route=Screens.AddGoal.route) {

            AddGoalPage(navController = navController)
        }

    }
}