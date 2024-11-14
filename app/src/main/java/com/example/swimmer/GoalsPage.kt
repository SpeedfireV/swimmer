package com.example.swimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.swimmer.data.models.DistanceMeasure


@Composable
fun GoalsPage(goals: List<DistanceMeasure>) {
    Scaffold() {
        innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            goals.forEach { distanceInfo ->
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(distanceInfo.riverName)
                    Text((distanceInfo.distanceSwimmed.toFloat() * 100 / distanceInfo.totalDistance).toString() + "% Swam")
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
    GoalsPage(goals = listOf(DistanceMeasure(riverName = "Vistula",totalDistance = 100, distanceSwimmed =  50)))
}



