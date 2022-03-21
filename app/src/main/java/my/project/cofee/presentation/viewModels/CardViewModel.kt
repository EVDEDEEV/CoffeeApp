package my.project.cofee.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.cofee.data.models.CardModel
import my.project.cofee.domain.useCase.CardUseCase

class CardViewModel(private val cardUseCase: CardUseCase) : ViewModel() {

    fun startInsert(
        nameProduct: String, imageProduct: String, priceProduct: String,
        idProduct: String, countProduct: String
    ) {
        insert(
            CardModel(0, nameProduct, imageProduct, priceProduct,
                idProduct, countProduct, (priceProduct.toInt() * countProduct.toInt()).toString()))

    }

    fun updateProductToCard(cardModel: CardModel) = viewModelScope.launch {
        cardUseCase.updateProductToCard(cardModel)
    }


    private fun insert(cardModel: CardModel) = viewModelScope.launch {
        cardUseCase.insert(cardModel)
    }


    val loadCoffeeFromCard = cardUseCase.loadCoffeeFromCard()

    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>> {
        return cardUseCase.loadCoffeeToCardFromCardProduct(idProduct)
    }

    fun deleteProductFromCard(idProduct: Int) = viewModelScope.launch {
        cardUseCase.deleteProductFromCard(idProduct)
    }

    fun deleteProductToCardFromCardProduct(idProduct: String) = viewModelScope.launch {
        cardUseCase.deleteProductToCardFromCardProduct(idProduct)
    }


    fun clearCard() = viewModelScope.launch {
        cardUseCase.clear()
    }


}
