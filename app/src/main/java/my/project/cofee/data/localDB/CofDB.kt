package my.project.cofee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.cofee.data.models.CoffeeModel

@Database(entities = [CoffeeModel::class], version = 1)
abstract class CofDB: RoomDatabase() {
    abstract val coffeeDao: CoffeeDao
}