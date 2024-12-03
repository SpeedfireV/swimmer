package com.example.swimmer.data.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Waves
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.swimmer.Screens

data class BottomNavBarItem(val text:String = "", val icon: ImageVector = Icons.Filled.Home, val route: String = "") {

    fun getBottomNavBarItems(): List<BottomNavBarItem> {
        return listOf(
            BottomNavBarItem(text = "Goals", icon = Icons.Filled.Pool, route= Screens.Goals.route),
            BottomNavBarItem(text = "Rivers", icon = Icons.Filled.Waves, route= Screens.Rivers.route),
        )
    }

}