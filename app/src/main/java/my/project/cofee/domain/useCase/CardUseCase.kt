package my.project.cofee.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.domain.repository.CardCall
import my.project.cofee.domain.repository.CoffeeCall

class CardUseCase(private val cardCall: CardCall) {

    suspend fun insert(cardModel: CardModel) {
        cardCall.insert(cardModel)
    }

    suspend fun updateProductToCard(cardModel: CardModel) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.updateProductToCard(cardModel)
        }
    }

    fun loadCoffeeFromCard(): LiveData<List<CardModel>> {
        return cardCall.loadCoffeeFromCard()
    }

    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>> {
        return cardCall.loadCoffeeToCardFromCardProduct(idProduct)
    }

    suspend fun deleteProductFromCard(idProduct: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.deleteProductFromCard(idProduct)
        }
    }

    suspend fun deleteProductToCardFromCardProduct(idProduct: String) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.deleteProductToCardFromCardProduct(idProduct)
        }
    }

    suspend fun clear() {
        cardCall.clear()
    }


}