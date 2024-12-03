package com.example.swimmer.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.swimmer.data.models.River

@Composable
fun RiverInfoPage(river: River){
    Text(text = river.riverName)
}