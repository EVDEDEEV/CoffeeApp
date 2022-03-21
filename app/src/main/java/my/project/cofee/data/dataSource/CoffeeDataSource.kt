package my.project.cofee.data.dataSource

import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CoffeeModel

interface CoffeeDataSource {

    fun insert(coffeeModel: CoffeeModel)

    fun loadCoffee() : LiveData<List<CoffeeModel>>

    suspend fun clear()
}