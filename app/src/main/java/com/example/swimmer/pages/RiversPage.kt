package com.example.swimmer.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swimmer.data.models.River

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiversPage(rivers: List<River> = listOf(River(riverName = "Vistula", totalDistance = 1000, description = "Description", countries = listOf("Poland", "Germany")), River(riverName = "Danube", totalDistance = 500), River())) {
    Scaffold { inlinePadding ->

        Column(
            modifier = Modifier.padding(inlinePadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Rivers", modifier = Modifier.fillMaxWidth())
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = "", onValueChange = {

            }, placeholder = {
                Text("Search for a river")
            })
            rivers.forEachIndexed() {
                index: Int, it: River ->
                Button (
                    onClick = {

                    },
                    shape= RectangleShape
                    ,
                    modifier = Modifier.background(
                        if (index % 2 == 0) MaterialTheme.colorScheme.inversePrimary.copy(
                            alpha = 0.65f
                        ) else MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.65f
                        )
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .height(32.dp)
                            .fillMaxWidth()



                    ) {
                        Text(text = it.riverName)
                        Text(text = it.totalDistance.toString())
                    }
                }

            }
        }
    }

}


@Preview(
    showBackground = true,
)
@Composable
fun RiversPagePreview( ){
    RiversPage()
}