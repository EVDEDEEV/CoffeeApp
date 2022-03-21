package my.project.cofee.domain.useCase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.OrderLocalModel
import my.project.cofee.domain.repository.CardCall
import my.project.cofee.domain.repository.OrderLocalCall

class OrderLocalUseCase(private val orderLocalCall: OrderLocalCall) {

    suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalCall.insert(orderLocalModel)
    }

}