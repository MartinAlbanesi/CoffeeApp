package com.example.coffeeapp.data.repositories

import com.example.coffeeapp.domain.model.CoffeeMakerModel
import kotlinx.coroutines.flow.Flow

interface CoffeeMakersRepository  {
    suspend fun listCoffeeMakers(): Flow<List<CoffeeMakerModel>>
}