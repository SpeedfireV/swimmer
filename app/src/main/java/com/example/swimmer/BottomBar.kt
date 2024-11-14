package com.example.swimmer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomBar() {
    BottomAppBar(actions = {
        IconButton(onClick = { /*TODO*/ }, ) {
            Icon(imageVector = Icons.Filled.Pool, contentDescription = "Swimming")
        }
        IconButton(onClick = { /*TODO*/ }, ) {
            Icon(imageVector = Icons.Filled.Waves, contentDescription = "Rivers")
        }
    }
        , floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")

            }
        })
}

@Preview(
    showBackground = true
)
@Composable
fun BottomBarPreview() {
    BottomBar()
}