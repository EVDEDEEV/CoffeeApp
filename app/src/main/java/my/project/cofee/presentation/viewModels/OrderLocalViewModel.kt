package my.project.cofee.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.OrderLocalModel
import my.project.cofee.domain.useCase.CardUseCase
import my.project.cofee.domain.useCase.OrderLocalUseCase

class OrderLocalViewModel(private val orderLocalUseCase: OrderLocalUseCase) : ViewModel() {

    fun startInsert(
        nameUser: String, phoneUser: String, description: String,
        totalPrice: String
    ) {
        insert(OrderLocalModel(0, nameUser, phoneUser, description, totalPrice))

    }


    private fun insert(orderLocalModel: OrderLocalModel) = viewModelScope.launch {
        orderLocalUseCase.insert(orderLocalModel)
    }

}
