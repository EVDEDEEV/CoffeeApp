package my.project.cofee.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.cofee.data.dataSource.CoffeeApiDataSource
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.localDB.CardDao
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.domain.repository.CardCall
import my.project.cofee.domain.repository.CoffeeCall

class CardRepository(private val dao: CardDao) : CardCall {


    override suspend fun insert(cardModel: CardModel) {
        dao.insert(cardModel)
    }

    override suspend fun updateProductToCard(cardModel: CardModel) {
        dao.updateProductToCard(cardModel)
    }

    override fun loadCoffeeFromCard(): LiveData<List<CardModel>> {
        return dao.loadCoffeeFromCard()
    }

    override fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>> {
        return dao.loadCoffeeToCardFromCardProduct(idProduct)
    }

    override suspend fun deleteProductFromCard(idProduct: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductFromCard(idProduct)
        }
    }

    override suspend fun deleteProductToCardFromCardProduct(idProduct: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductToCardFromCardProduct(idProduct)
        }
    }

    override suspend fun clear() {
        dao.clear()
    }



}