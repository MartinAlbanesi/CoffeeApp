package com.example.coffeeapp.ui.composables.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.coffeeapp.domain.model.CoffeeMakerModel

@Composable
fun CoffeeMakerListItem(coffeeMaker: CoffeeMakerModel, navController: NavHostController) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .clickable {
                try{
                    navController.navigate("details/${coffeeMaker.id}")
                }catch (e: Exception){
                    Log.d("CoffeeMakerListItem", "CoffeeMakerListItem: ${e.message}")
                }

            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageLoader(coffeeMaker.imageUrl)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = coffeeMaker.name,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}