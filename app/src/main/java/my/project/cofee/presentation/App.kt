package my.project.cofee.presentation

import android.app.Application
import my.project.cofee.presentation.di.card
import my.project.cofee.presentation.di.coffee
import my.project.cofee.presentation.di.order
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@App)

            modules(coffee, card, order)
        }
    }
}