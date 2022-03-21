package my.project.cofee.domain.repository

import my.project.cofee.data.models.OrderLocalModel

interface OrderLocalCall {

    suspend fun insert(orderLocalModel: OrderLocalModel)
}