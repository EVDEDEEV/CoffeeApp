package my.project.cofee.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.cofee.domain.useCase.CoffeeUseCase

class CoffeeViewModel(private val coffeeUseCase: CoffeeUseCase): ViewModel() {

    val loadCoffee = coffeeUseCase.loadCoffee()

    fun migration(context: Context) = viewModelScope.launch {
        coffeeUseCase.startMigration(context)
    }
}