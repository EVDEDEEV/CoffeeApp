package my.project.cofee.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.data.models.OrderLocalModel

@Dao
interface OrderLocalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderLocalModel: OrderLocalModel)

    @Query("SELECT * FROM order_local_data_table")
    fun loadOrder(): LiveData<List<OrderLocalModel>>

}