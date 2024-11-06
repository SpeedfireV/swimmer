package com.example.swimmer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.swimmer.ui.theme.SwimmerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            var distanceMeasure = DistanceMeasure(totalDistance = 100, distanceSwimmed =  50)
            var textValue by remember {
                mutableStateOf(distanceMeasure.totalDistance.toString())
            }
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            SwimmerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
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
                    },
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                ) { innerPadding ->
                    Column(modifier= Modifier
                        .fillMaxSize()
                        .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "Swim Measurement App",
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.padding(top = 32.dp)
                            ) {
                                Text("You have to swim ${distanceMeasure.totalDistance} km", textAlign = TextAlign.Center)
                                Text("You've already swimmed ${distanceMeasure.distanceSwimmed} out of ${distanceMeasure.totalDistance} which is ${distanceMeasure.swimPercent}% of the distance!", textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp))
                            }
                        }
                        Column (horizontalAlignment = Alignment.CenterHorizontally) {

                                TextField(modifier = Modifier.padding(bottom=16.dp), value = textValue, singleLine = true, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number), onValueChange = {
                                    textValue = it
                                }, label = {
                                    Text("Enter Distance Swimmed")
                                })

                            TextButton(onClick = {
                                distanceMeasure = distanceMeasure.copy(distanceSwimmed = distanceMeasure.distanceSwimmed + textValue.toInt())
                                textValue = ""
                                scope.launch {
                                    snackbarHostState.showSnackbar("Added distance!")
                                }
                            }) {
                                Text(text = "Add Distance")
                            }
                        }

                    }
                }
            }
        }
    }
}