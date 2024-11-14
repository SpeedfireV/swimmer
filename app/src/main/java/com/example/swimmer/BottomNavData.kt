package com.example.swimmer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Waves
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavData(val text:String = "", val icon: ImageVector = Icons.Filled.Home, val route: String = "") {

    fun bottomNavItems(): List<BottomNavData> {
        return listOf(
            BottomNavData(text = "Goals", icon = Icons.Filled.Pool, route= NavigationItem.Goals.route),
            BottomNavData(text = "Rivers", icon = Icons.Filled.Waves, route= NavigationItem.Rivers.route),
        )
    }

}