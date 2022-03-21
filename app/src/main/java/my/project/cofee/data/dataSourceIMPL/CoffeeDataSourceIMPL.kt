package my.project.cofee.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.localDB.CoffeeDao
import my.project.cofee.data.models.CoffeeModel

class CoffeeDataSourceIMPL(private val dao: CoffeeDao): CoffeeDataSource {

    override fun insert(coffeeModel: CoffeeModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(coffeeModel)
        }
    }

    override fun loadCoffee() : LiveData<List<CoffeeModel>> {
        return dao.loadCoffee()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()
        }
    }
}