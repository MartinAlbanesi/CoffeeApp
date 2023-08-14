package com.example.coffeeapp.ui.composables

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.example.coffeeapp.data.repositories.MockCoffeeMakersRepository
import com.example.coffeeapp.domain.GetCoffeMakersUseCase
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import com.example.coffeeapp.ui.viewmodels.CoffeeMakersViewModel
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CustomHorizontalGrid (coffeeMakersVM: CoffeeMakersViewModel) {
    val coffeeMakersList = coffeeMakersVM.allCoffeeMakersList
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "Coffee Makers",
                modifier = Modifier
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )
        }
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            Modifier
                .aspectRatio(2f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            content = {
                if (coffeeMakersList.isNotEmpty()) {
                    coffeeMakersList.forEach { coffeeMaker ->
                        item {
                            Box(
                                modifier = Modifier
                                    .width(170.dp)
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(MaterialTheme.colorScheme.secondary)
                                    .clickable {
                                        Log.d("CoffeeApp", "Item ${coffeeMaker.name} clicked")
                                    },
                                contentAlignment = Alignment.TopCenter
                            ) {
                                ImageLoader(coffeeMaker.imageUrl)

                                Log.d("ImageLoader", "Item ${coffeeMaker.imageUrl} loaded")

                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter),
                                    border = BorderStroke(2.dp, Color.Black)
                                ) {
                                    Text(
                                        text = "Item ${coffeeMaker.name}",
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                    )
                                }

                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun ImageLoader(imageUrl: String) {
    CoilImage(
        imageModel = imageUrl,
        contentDescription = "Coffee Maker Image",
        contentScale = ContentScale.Crop,
        imageLoader = ImageLoader.Builder(LocalContext.current)
            .crossfade(true)
            .build(),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .aspectRatio(1f)
    )
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun CoffeeAppPreview() {

    val mockCoffeeMakersRepository = MockCoffeeMakersRepository()
    val getCoffeMakersUseCase = GetCoffeMakersUseCase(mockCoffeeMakersRepository)
    val viewModel = CoffeeMakersViewModel(getCoffeMakersUseCase)

    CoffeeAppTheme {
        CustomHorizontalGrid(viewModel)
    }
}