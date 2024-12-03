package com.example.swimmer.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalPage(navController: NavHostController = rememberNavController()) {
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis.let {

    }

    val showDatepicker by remember {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(32.dp))
        Text("Add Goal Page")
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp),value = "", onValueChange = {

    }, prefix = {
        Icon(imageVector = Icons.Filled.CalendarMonth, contentDescription = "Deadline")
        },label ={
        Text(text = "Goal Deadline")
        }, placeholder = {
            Text(text = "I will achieve this in a year!")
        })
        if (showDatepicker) {
            DockedDatePicker(datePickerState = datePickerState)

        }
        Spacer(modifier = Modifier.height(16.dp))


        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),onClick = {
                navController.popBackStack()
            }) {
            Text(text = "Add Goal")
            
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DockedDatePicker(datePickerState: DatePickerState) {
    Popup {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 64.dp)
                .shadow(elevation = 4.dp)
                .padding(horizontal = 16.dp)
                .background(
                    MaterialTheme.colorScheme.surface
                )
        ){
            DatePicker(state = datePickerState, showModeToggle = false)
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AddGoalPagePreview() {
    AddGoalPage()
}