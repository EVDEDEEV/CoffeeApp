package my.project.cofee.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.cofee.data.dataSource.CoffeeApiDataSource
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.domain.repository.CoffeeCall

class CoffeeRepository(
    private val coffeeApiDataSource: CoffeeApiDataSource,
    private val coffeeDataSource: CoffeeDataSource,
) : CoffeeCall {

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return coffeeDataSource.loadCoffee()
    }

    override suspend fun startMigration(context: Context) {
        coffeeDataSource.clear()
        coffeeApiDataSource.startMigration(context)
    }

}