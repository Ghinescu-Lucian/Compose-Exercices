package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Important imports
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
//
//@Composable
//fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
//    Column(
//        modifier = modifier.padding(16.dp)
//    ){
//        if(count > 0){
//            Text("You've had $count glasses.")
//        }
//        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10){
//            Text("Add one")
//        }
//    }
//}
//
//@Composable
//fun StatefullCounter(modifier: Modifier = Modifier){
//    var watercount by remember {
//        mutableStateOf(0)
//    }
//    StatelessCounter(count = watercount, onIncrement = {watercount++ }, modifier)
//    var juiceCount by remember {
//        mutableStateOf(0)
//    }
////    StatelessCounter(count = juiceCount, onIncrement = {juiceCount++ }, modifier)
//}
//
//@Composable
//fun WaterCounter ( modifier : Modifier = Modifier) {
//    Column(
//        modifier = modifier.padding(16.dp)
//    ){
////            val count : MutableState<Int> =  remember {mutableStateOf(0)}
//
//        var count by rememberSaveable { mutableStateOf(0) }
//
//            if(count>0) {
//
////                var showTask by remember { mutableStateOf(true) }
////                if(showTask){
////                    WellnessTaskItem(
////                        taskName = "Have you taken your 15 minute walk today?",
////                        onClose = { showTask = false }
////                    )
////                }
//                Text(
//                    text = "You've had ${count} glasses.",
//                    modifier = modifier.padding(16.dp)
//                )
//            }
//
//                Button(
//                    onClick = { count++ },
//                    modifier = Modifier.padding(top = 8.dp),
//                    enabled = count<10
//                ) {
//                    Text(
//                        "Add one"
//                    )
//                }
////        Row(Modifier.padding(top = 8.dp)) {
////            Button(onClick = { count++ }, enabled = count < 10) {
////                Text("Add one")
////            }
////            Button(
////                onClick = { count = 0 },
////                Modifier.padding(start = 8.dp)) {
////                Text("Clear water count")
////            }
////        }
//
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewStatefullCounter(){
//    MaterialTheme {
//        StatefullCounter()
//    }
//}


@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}