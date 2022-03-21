package my.project.cofee.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CoffeeModel

interface CoffeeCall {

    fun loadCoffee(): LiveData<List<CoffeeModel>>

    suspend fun startMigration(context: Context)
}