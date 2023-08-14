package com.example.coffeeapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.domain.GetCoffeMakersUseCase
import com.example.coffeeapp.domain.model.CoffeeMakerModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeMakersViewModel @Inject constructor(
    getCoffeeMakersUseCase: GetCoffeMakersUseCase
    ): ViewModel() {

    var allCoffeeMakersList = listOf<CoffeeMakerModel>()

    init {
        viewModelScope.launch {
            delay(5000)
            getCoffeeMakersUseCase.invoke()
                .collect { coffeeMakersList ->
                    allCoffeeMakersList = coffeeMakersList
                }
        }
    }

}