package com.example.coffeeapp.di

import android.content.Context
import com.example.coffeeapp.data.repositories.CoffeeMakersRepository
import com.example.coffeeapp.data.repositories.MockCoffeeMakersRepository
import com.example.coffeeapp.domain.GetCoffeMakersUseCase
import com.example.coffeeapp.ui.viewmodels.CoffeeMakersViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoffeeMakersRepository(): CoffeeMakersRepository {
        return MockCoffeeMakersRepository()
    }

    @Provides
    @Singleton
    fun provideGetCoffeeMakersUseCase(): GetCoffeMakersUseCase {
        return GetCoffeMakersUseCase(provideCoffeeMakersRepository())
    }

    @Provides
    @Singleton
    fun provideCoffeeMakersViewModel(): CoffeeMakersViewModel {
        return CoffeeMakersViewModel(provideGetCoffeeMakersUseCase())
    }

}