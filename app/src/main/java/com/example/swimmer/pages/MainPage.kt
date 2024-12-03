package com.example.swimmer.pages//package com.example.swimmer
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.SnackbarHostState
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.example.swimmer.data.models.DistanceMeasure
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//@Composable
//fun MainPage(innerPadding: PaddingValues, distanceMeasure: DistanceMeasure, textValue: String, scope: CoroutineScope, snackbarHostState: SnackbarHostState) {
//    Column(modifier= Modifier
//        .fillMaxSize()
//        .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
//        Column (horizontalAlignment = Alignment.CenterHorizontally){
//            GoalsPage(navC,goals = listOf(distanceMeasure))
//            Text(
//                text = "Swim Measurement App",
//            )
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.spacedBy(10.dp),
//                modifier = Modifier.padding(top = 32.dp)
//            ) {
//                Text("You have to swim ${distanceMeasure.totalDistance} km", textAlign = TextAlign.Center)
//                Text("You've already swimmed ${distanceMeasure.distanceSwimmed} out of ${distanceMeasure.totalDistance} which is ${distanceMeasure.swimPercent}% of the distance!", textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp))
//            }
//        }
//        Column (horizontalAlignment = Alignment.CenterHorizontally) {
//
//            TextField(modifier = Modifier.padding(bottom=16.dp), value = textValue, singleLine = true, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number), onValueChange = {
//
//            }, label = {
//                Text("Enter Distance Swimmed")
//            })
//
//            TextButton(onClick = {
//                scope.launch {
//                    snackbarHostState.showSnackbar("Added distance!")
//                }
//            }) {
//                Text(text = "Add Distance")
//            }
//        }
//
//    }
//}