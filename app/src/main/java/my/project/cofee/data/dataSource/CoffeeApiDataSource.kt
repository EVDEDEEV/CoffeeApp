package my.project.cofee.data.dataSource

import android.content.Context

interface CoffeeApiDataSource {
    fun startMigration (context: Context)
}