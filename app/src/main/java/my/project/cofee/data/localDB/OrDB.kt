package my.project.cofee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.OrderLocalModel

@Database(entities = [OrderLocalModel::class], version = 1)
abstract class OrDB:RoomDatabase() {
    abstract val orderLocalDao: OrderLocalDao
}