package com.example.coffeeapp.domain

import com.example.coffeeapp.data.repositories.CoffeeMakersRepository
import javax.inject.Inject

class GetCoffeMakersUseCase @Inject constructor(private val repository: CoffeeMakersRepository){
    suspend operator fun invoke() = repository.listCoffeeMakers()
}