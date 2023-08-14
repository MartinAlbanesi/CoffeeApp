package com.example.coffeeapp.ui.activities

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeapp.data.repositories.MockCoffeeMakersRepository
import com.example.coffeeapp.di.MainApplication
import com.example.coffeeapp.domain.GetCoffeMakersUseCase
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import com.example.coffeeapp.ui.composables.CustomHorizontalGrid
import com.example.coffeeapp.ui.viewmodels.CoffeeMakersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    private val coffeeMakersViewModel: CoffeeMakersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CoffeeAppTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoffeeMakersMenu(coffeeMakersViewModel)
                }
            }
        }
    }
}

@Composable
fun CoffeeMakersMenu(coffeeMakersVM: CoffeeMakersViewModel) {
    Box {
        ScaffoldWithTopBar(coffeeMakersVM)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScaffoldWithTopBar(coffeeMakersVM: CoffeeMakersViewModel) {
    Scaffold(
        topBar = {
            // TopAppBar with navigation icon and title
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Home")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, "menuIcon", tint = MaterialTheme.colorScheme.secondary)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.secondary,
                ),
            )
        }, content = {
            //Content of the screen
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomHorizontalGrid(coffeeMakersVM)
            }
        })
}

@Preview(name="Light Mode", showBackground = true)
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
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
            CoffeeMakersMenu(viewModel)
        }
    }
}