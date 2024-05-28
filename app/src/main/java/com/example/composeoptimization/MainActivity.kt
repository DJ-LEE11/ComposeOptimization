package com.example.composeoptimization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeoptimization.ui.theme.ComposeOptimizationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ComposeOptimizationTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            AppNavHost()
        }
    }
}

@Composable
private fun AppNavHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Page.Home.name,
    ) {
        composable(route = Page.Home.name) {
            Home(
                onFirstClick = { navController.navigate(Page.First.name) },
                onSecondClick = { navController.navigate(Page.Second.name) },
                onThirdClick = { navController.navigate(Page.Third.name) }
            )
        }

        composable(route = Page.First.name) {
            ScreenA(
                onNextClick = { navController.navigate(Page.Second.name) }
            )
        }

        composable(route = Page.Second.name) {
            ScreenB(
                onBackClick = { navController.navigateUp() },
                onNextClick = { navController.navigate(Page.Third.name) },
            )
        }

        composable(route = Page.Third.name) {
            ScreenC(
                onBackClick = { navController.navigateUp() },
                onResetClick = {
                    navController.popBackStack(
                        route = Page.First.name,
                        inclusive = false
                    )
                }
            )
        }
    }
}

@Composable
private fun Home(
    onFirstClick: () -> Unit,
    onSecondClick: () -> Unit,
    onThirdClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = onFirstClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to First")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSecondClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Second")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onThirdClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Third")
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
private fun ScreenA(
    onNextClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Screen A",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Navigate to Screen B")
        }
    }
}

@Composable
private fun ScreenB(
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Screen B",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Screen A")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Screen C")
        }

    }
}

@Composable
private fun ScreenC(
    onBackClick: () -> Unit,
    onResetClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Screen C",
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Screen B")
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onResetClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Screen A (PopupTo with Inclusive)")
        }
    }
}