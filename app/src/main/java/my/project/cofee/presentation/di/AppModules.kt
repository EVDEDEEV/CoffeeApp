package my.project.cofee.presentation.di

import androidx.room.Room
import my.project.cofee.data.dataSource.CoffeeApiDataSource
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import my.project.cofee.data.dataSourceIMPL.CoffeeDataSourceIMPL
import my.project.cofee.data.localDB.CadDB
import my.project.cofee.data.localDB.CofDB
import my.project.cofee.data.localDB.OrDB
import my.project.cofee.data.repository.CardRepository
import my.project.cofee.data.repository.CoffeeRepository
import my.project.cofee.data.repository.OrderLocalRepository
import my.project.cofee.domain.repository.CardCall
import my.project.cofee.domain.repository.CoffeeCall
import my.project.cofee.domain.repository.OrderLocalCall
import my.project.cofee.domain.useCase.CardUseCase
import my.project.cofee.domain.useCase.CoffeeUseCase
import my.project.cofee.domain.useCase.OrderLocalUseCase
import my.project.cofee.presentation.viewModels.CardViewModel
import my.project.cofee.presentation.viewModels.CoffeeViewModel
import my.project.cofee.presentation.viewModels.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coffee = module {

    single {
        Room.databaseBuilder(androidContext(), CofDB::class.java,
            "cofDB").build()
    }

    single { get<CofDB>().coffeeDao }


    single<CoffeeDataSource> {
        CoffeeDataSourceIMPL(
            get()
        )
    }

    single<CoffeeApiDataSource> {
        CoffeeApiDataSourceIMPL(
            get()
        )
    }

    single<CoffeeCall> { CoffeeRepository(get(), get()) }

    single { CoffeeUseCase(get()) }

    viewModel { CoffeeViewModel(get()) }

}

val card = module {

    single {
        Room.databaseBuilder(androidContext(), CadDB::class.java,
            "cadDB").build()
    }

    single { get<CadDB>().cardDao }

    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}

val order = module {

    single {
        Room.databaseBuilder(androidContext(), OrDB::class.java,
            "orDB").build()
    }

    single { get<OrDB>().orderLocalDao }

    single<OrderLocalCall> { OrderLocalRepository(get()) }

    single { OrderLocalUseCase(get()) }

    viewModel { OrderLocalViewModel(get()) }

}

