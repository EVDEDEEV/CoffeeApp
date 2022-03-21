package my.project.cofee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.cofee.data.models.CardModel

@Database(entities = [CardModel::class], version = 1)
abstract class CadDB: RoomDatabase() {
    abstract val cardDao: CardDao

}