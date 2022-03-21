package my.project.cofee.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.cofee.data.dataSource.CoffeeApiDataSource
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.localDB.OrderLocalDao
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.data.models.OrderLocalModel
import my.project.cofee.domain.repository.CoffeeCall
import my.project.cofee.domain.repository.OrderLocalCall

class OrderLocalRepository(
    private val orderLocalDao: OrderLocalDao
) : OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)
    }


}