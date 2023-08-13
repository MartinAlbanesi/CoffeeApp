package com.example.coffeeapp.ui.composables

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.ui.theme.CoffeeAppTheme

@Composable
fun CustomHorizontalGrid(items: List<String>) {
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
                items(items.size) { i ->
                    Box(
                        modifier = Modifier
                            .width(170.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(MaterialTheme.colorScheme.secondary)
                            .clickable {
                                Log.d("CoffeeApp", "Item ${i + 1} clicked")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Item ${items[i]}", color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
        )
    }
}


@Preview(name="Light Mode", showBackground = true)
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun CoffeeAppPreview() {
    CoffeeAppTheme {
        CustomHorizontalGrid(items = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"))
    }
}