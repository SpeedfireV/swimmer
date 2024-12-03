package com.example.swimmer.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.swimmer.Screens
import com.example.swimmer.data.models.DistanceMeasure


@Composable
fun GoalsPage(navController: NavHostController,goals: List<DistanceMeasure>) {
    Scaffold (floatingActionButton = {
        FloatingActionButton(onClick = { 
            navController.navigate(Screens.AddGoal.route)
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Goal")

        }
    }){
        innerPadding ->
        Box (modifier = Modifier.padding(innerPadding)){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Your Goals"
                )
                Spacer(modifier = Modifier.height(16.dp))
                goals.forEach { distanceInfo ->
                    Button(
                        onClick = {
                            navController.navigate(Screens.RiverInfo.route)
                        }, modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(56.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column {
                                Text(distanceInfo.riverName)
                                Text(distanceInfo.totalDistance.toString() + " km")
                            }
                            Text((distanceInfo.distanceSwimmed.toFloat() * 100 / distanceInfo.totalDistance).toString() + "% Swam (100.3 km)")
                        }

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun GoalsPagePreview() {
    val goals: List<DistanceMeasure> = listOf(DistanceMeasure(riverName = "Vistula", totalDistance = 1200, distanceSwimmed = 700))
    Scaffold (floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Goal")

        }
    }){
            innerPadding ->
        Box (modifier = Modifier.padding(innerPadding)){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Your Goals"
                )
                Spacer(modifier = Modifier.height(16.dp))
                goals.forEach { distanceInfo ->
                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(56.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column {
                                Text(distanceInfo.riverName)
                                Text(distanceInfo.totalDistance.toString() + " km")
                            }
                            Text((distanceInfo.distanceSwimmed.toFloat() * 100 / distanceInfo.totalDistance).toString() + "% Swam (100.3 km)")
                        }

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


