package com.example.coffeeapp.data.repositories

import com.example.coffeeapp.domain.models.CoffeeMakerModel
import kotlinx.coroutines.flow.Flow

interface CoffeeRepository  {
    suspend fun listCoffeeMakers(): Flow<List<CoffeeMakerModel>>
}