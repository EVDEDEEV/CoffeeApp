package my.project.cofee.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.domain.repository.CoffeeCall

class CoffeeUseCase(private val coffeeCall: CoffeeCall) {

    fun loadCoffee(): LiveData<List<CoffeeModel>> {

        return coffeeCall.loadCoffee()
    }

    suspend fun startMigration(context: Context) {

        coffeeCall.startMigration(context)
    }
}