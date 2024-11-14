package com.example.swimmer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    val startDestinationRoute = NavigationItem.Goals.route  // Set your desired start route here


    Scaffold(modifier = Modifier, bottomBar = {
        NavigationBar {
            BottomNavData().bottomNavItems().forEachIndexed { index, bottomNavData ->
                NavigationBarItem(selected = navigationSelectedItem == index , onClick = {
                    navigationSelectedItem = index
                    navController.navigate(bottomNavData.route) {
                        popUpTo(startDestinationRoute) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }, icon = {
                    Icon(imageVector = bottomNavData.icon, contentDescription = bottomNavData.text)
                }, label = {
                    Text(text = bottomNavData.text)
                })
                
            }
        }
    }) {
        innerPadding -> Column(modifier = Modifier.padding(innerPadding)) {
            AppNavHost(navController = navController)

    }
    }
}