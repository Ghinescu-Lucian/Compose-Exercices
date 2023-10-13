package com.example.composebasics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

// Important import
//import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color =  colorResource(id = R.color.back)
//                ) {
//                    Greeting("Android")
                    MyApp(modifier = Modifier.fillMaxSize())
//                OnboardingScreen( onContinueClicked = {shouldShowOnboarding = false})
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var expanded = remember {
        mutableStateOf(false)
    }

//    val extraPadding = if( expanded.value) 48.dp else 0.dp

//    Animating
    val extraPadding by animateDpAsState(
        if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = colorResource(id = R.color.teal_200),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)

    ) {
        Row(
            modifier = modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
//                    .padding(bottom = extraPadding.coerceAtLeast(0.dp)) // .coereceAtLeast() face ca sa inchida elementul

//                    .fillMaxWidth()
            ) {
                Text(
                    text = "Hello,",
                    modifier = modifier

                )
                Text(
                    text = "$name!",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
//                    color = colorResource(id = R.color.white),
//
                    modifier = modifier

                )
                if(expanded.value) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
//            ElevatedButton(
            IconButton(
                onClick = {
                    expanded.value = !expanded.value
                }

            ){
                Icon(
                    imageVector = if(expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription =  if(expanded.value){
                        stringResource(id = R.string.show_less)
                    } else { stringResource(id = R.string.show_more) }
                )
//                Text(
//                    if(expanded.value) "Show less"
//                            else "Show more"
//                )
            }


        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
//        Greeting("Android")
//        MyApp(modifier = Modifier.fillMaxSize())
//        OnboardingScreen()
        Greetings2()

    }
}


@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {

Greetings2()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(
    showBackground = true,
    widthDp = 320
)
@Composable
fun MyAppPreview(){
    ComposeBasicsTheme {
        MyApp(Modifier.fillMaxSize())
    }
}


@Composable
fun Greetings2(
    modifier: Modifier = Modifier,
    names: List<String> =   List(1000) { "$it"}//listOf("World", "Compose")
){
    Surface(
        modifier = modifier,
//        color = colorResource(id = R.color.teal_200)
    ){
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
//            for(name in names)
            items(items = names) { name ->
                Greeting(name = name)
            }

        }
    }

}

@Composable
private fun MyApp(modifier: Modifier = Modifier){

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true)}
    Surface(modifier){
        if(shouldShowOnboarding){
            OnboardingScreen( onContinueClicked = {shouldShowOnboarding = false})
        }
        else {
            Greetings2()
        }
    }
//    Greetings2()
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier,
onContinueClicked: () -> Unit
){
//    var shouldShowOnboarding = remember {
//        mutableStateOf(true)
//    }

//    var shouldShowOnboarding by remember { mutableStateOf(true) }


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
//            onClick = {shouldShowOnboarding.value = false}
        onClick = onContinueClicked
        ){
            Text("Continue")
        }
    }
}