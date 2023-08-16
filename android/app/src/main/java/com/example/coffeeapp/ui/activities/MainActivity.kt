package com.example.coffeeapp.ui.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeeapp.data.repositories.MockCoffeeMakersRepository
import com.example.coffeeapp.domain.GetCoffeMakersUseCase
import com.example.coffeeapp.ui.composables.detail.DetailsScreen
import com.example.coffeeapp.ui.composables.home.ScaffoldWithTopBar
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import com.example.coffeeapp.ui.viewmodels.CoffeeMakersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val coffeeMakersViewModel: CoffeeMakersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CoffeeAppTheme(darkTheme = true) {
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        HomeScreen(navController, coffeeMakersViewModel)
                    }
                    composable(
                        route = "details/{coffeeMakerId}",
                        arguments = listOf(
                            navArgument("coffeeMakerId") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("coffeeMakerId")
                        requireNotNull(id) { "Coffee Maker Id is null" } //This message will show if id is null
                        DetailsScreen(id)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, coffeeMakersVM: CoffeeMakersViewModel) {
    ScaffoldWithTopBar(navController, coffeeMakersVM)
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun CoffeeAppPreview() {

    val mockCoffeeMakersRepository = MockCoffeeMakersRepository()
    val getCoffeMakersUseCase = GetCoffeMakersUseCase(mockCoffeeMakersRepository)
    val viewModel = CoffeeMakersViewModel(getCoffeMakersUseCase)

    CoffeeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            //ScaffoldWithTopBar(navController, viewModel)
        }
    }
}